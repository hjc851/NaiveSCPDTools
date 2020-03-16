package me.haydencheers.nscpdt.pdg

import com.github.javaparser.ast.*
import com.github.javaparser.ast.body.*
import com.github.javaparser.ast.comments.*
import com.github.javaparser.ast.expr.*
import com.github.javaparser.ast.modules.*
import com.github.javaparser.ast.stmt.*
import com.github.javaparser.ast.type.*
import com.github.javaparser.ast.visitor.VoidVisitor

object PDGVisitor: VoidVisitor<BuilderContext> {
    override fun visit(n: NodeList<*>, ctx: BuilderContext) {
        val _lastControlNode = ctx.lastControlNode
        for (node in n) {
            node.accept(this, ctx)
            ctx.lastControlNode = _lastControlNode
        }
    }

    override fun visit(n: AnnotationDeclaration, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: AnnotationMemberDeclaration, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: ArrayAccessExpr, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: ArrayCreationExpr, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: ArrayCreationLevel, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: ArrayInitializerExpr, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: ArrayType, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: AssertStmt, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: AssignExpr, ctx: BuilderContext) {
        val lhs = n.target.accept(ASTVariableResolver, ctx)
        val rhs = n.value.accept(ASTVariableResolver, ctx)

        n.value.accept(this, ctx)
        n.target.accept(this, ctx)

        // All future var references now have a control dependency on this node
        if (lhs != null) {
            val holder = ctx.lookupOrCreateVariableByName(lhs.name)
            holder.currentNodeId = ctx.lastControlNode.id
        }
    }

    override fun visit(n: BinaryExpr, ctx: BuilderContext) {
        n.left.accept(this, ctx)
        n.right.accept(this, ctx)
    }

    override fun visit(n: BlockComment, ctx: BuilderContext) {}

    override fun visit(n: BlockStmt, ctx: BuilderContext) {
        ctx.pushScope()
        n.statements.accept(this, ctx)
        ctx.popScope()
    }

    override fun visit(n: BooleanLiteralExpr, ctx: BuilderContext) {}

    override fun visit(n: BreakStmt, ctx: BuilderContext) {
        val node = ctx.getGraphNodeForTreeNode(n)
        ctx.makeControlDependency(ctx.lastControlNode, node)
    }

    override fun visit(n: CastExpr, ctx: BuilderContext) {
        n.expression.accept(this, ctx)
    }

    override fun visit(n: CatchClause, ctx: BuilderContext) {
        val node = ctx.getGraphNodeForTreeNode(n, "catch (${n.parameter})")
        ctx.makeControlDependency(ctx.lastControlNode, node)

        ctx.lastControlNode = node
        n.parameter.accept(this, ctx)
        n.body.accept(this, ctx)
    }

    override fun visit(n: CharLiteralExpr, ctx: BuilderContext) {}

    override fun visit(n: ClassExpr, ctx: BuilderContext) {}

    override fun visit(n: ClassOrInterfaceDeclaration, ctx: BuilderContext) {}

    override fun visit(n: ClassOrInterfaceType, ctx: BuilderContext) {}

    override fun visit(n: CompilationUnit, ctx: BuilderContext) {}

    override fun visit(n: ConditionalExpr, ctx: BuilderContext) {
        n.condition.accept(this, ctx)
        n.thenExpr.accept(this, ctx)
        n.elseExpr.accept(this, ctx)
    }

    override fun visit(n: ConstructorDeclaration, ctx: BuilderContext) {
        ctx.pushScope()
        val node = ctx.makeRootNode(n.signature)
        ctx.lastControlNode = node
        for (parameter in n.parameters) {
            val dnode = ctx.declareLocal(parameter.nameAsString)
            ctx.makeControlDependency(node, dnode)
        }
        n.body.accept(this, ctx)
        ctx.popScope()
    }

    override fun visit(n: ContinueStmt, ctx: BuilderContext) {
        val node = ctx.getGraphNodeForTreeNode(n)
        ctx.makeControlDependency(ctx.lastControlNode, node)
    }

    override fun visit(n: DoStmt, ctx: BuilderContext) {
        val node = ctx.getGraphNodeForTreeNode(n, "do {...} while (${n.condition})")
        ctx.makeControlDependency(ctx.lastControlNode, node)

        ctx.lastControlNode = node
        n.condition.accept(this, ctx)
        n.body.accept(this, ctx)
    }

    override fun visit(n: DoubleLiteralExpr, ctx: BuilderContext) {}

    override fun visit(n: EmptyStmt, ctx: BuilderContext) {}

    override fun visit(n: EnclosedExpr, ctx: BuilderContext) {
        n.inner.accept(this, ctx)
    }

    override fun visit(n: EnumConstantDeclaration, ctx: BuilderContext) {}

    override fun visit(n: EnumDeclaration, ctx: BuilderContext) {}

    override fun visit(n: ExplicitConstructorInvocationStmt, ctx: BuilderContext) {}

    override fun visit(n: ExpressionStmt, ctx: BuilderContext) {
        val node = ctx.getGraphNodeForTreeNode(n)
        ctx.makeControlDependency(ctx.lastControlNode, node)

        ctx.lastControlNode = node
        n.expression.accept(this, ctx)
    }

    override fun visit(n: FieldAccessExpr, ctx: BuilderContext) {
        n.scope.accept(this, ctx)
        n.name.accept(this, ctx)
    }

    override fun visit(n: FieldDeclaration, ctx: BuilderContext) {}

    override fun visit(n: ForStmt, ctx: BuilderContext) {
        val node = ctx.getGraphNodeForTreeNode(n, "for (${n.initialization}; ${n.compare}; ${n.update}")
        ctx.makeControlDependency(ctx.lastControlNode, node)

        ctx.lastControlNode = node
        n.initialization.accept(this, ctx)
        n.compare.ifPresent { it.accept(this, ctx) }
        n.update.accept(this, ctx)
        n.body.accept(this, ctx)
    }

    override fun visit(n: ForEachStmt, ctx: BuilderContext) {
        val node = ctx.getGraphNodeForTreeNode(n, "for (${n.variable} : ${n.iterable})")
        ctx.makeControlDependency(ctx.lastControlNode, node)

        ctx.lastControlNode = node
        n.variable.accept(this, ctx)
        n.iterable.accept(this, ctx)
        n.body.accept(this, ctx)
    }

    override fun visit(n: IfStmt, ctx: BuilderContext) {
        val node = ctx.getGraphNodeForTreeNode(n, "if (${n.condition})")
        ctx.lastControlNode = node

        n.condition.accept(this, ctx)

        n.thenStmt.accept(this, ctx)
        n.elseStmt.ifPresent {
            ctx.lastControlNode = node
            it.accept(this, ctx)
        }
    }

    override fun visit(n: ImportDeclaration, ctx: BuilderContext) {}

    override fun visit(n: InitializerDeclaration, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: InstanceOfExpr, ctx: BuilderContext) {
        n.expression.accept(this, ctx)
    }

    override fun visit(n: IntegerLiteralExpr, ctx: BuilderContext) {}

    override fun visit(n: IntersectionType, ctx: BuilderContext) {}

    override fun visit(n: JavadocComment, ctx: BuilderContext) {}

    override fun visit(n: LabeledStmt, ctx: BuilderContext) {
        n.statement.accept(this, ctx)
    }

    override fun visit(n: LambdaExpr, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: LineComment, ctx: BuilderContext) {}

    override fun visit(n: LocalClassDeclarationStmt, ctx: BuilderContext) {}

    override fun visit(n: LongLiteralExpr, ctx: BuilderContext) {}

    override fun visit(n: MarkerAnnotationExpr, ctx: BuilderContext) {}

    override fun visit(n: MemberValuePair, ctx: BuilderContext) {}

    override fun visit(n: MethodCallExpr, ctx: BuilderContext) {
        n.scope.ifPresent { it.accept(this, ctx) }
        for (arg in n.arguments) {
            arg.accept(this, ctx)
        }
    }

    override fun visit(n: MethodDeclaration, ctx: BuilderContext) {
        ctx.pushScope()
        val node = ctx.makeRootNode(n.signature)
        ctx.lastControlNode = node
        for (parameter in n.parameters) {
            val dnode = ctx.declareLocal(parameter.nameAsString)
            ctx.makeControlDependency(node, dnode)
        }
        n.body.ifPresent { it.accept(this, ctx) }
        ctx.popScope()
    }

    override fun visit(n: MethodReferenceExpr, ctx: BuilderContext) {
        n.scope.accept(this, ctx)
    }

    override fun visit(n: NameExpr, ctx: BuilderContext) {
        n.name.accept(this, ctx)
    }

    override fun visit(n: Name, ctx: BuilderContext) {
        val variableholder = ctx.lookupOrCreateVariableByName(n.asString())
        val node = ctx.getGraphNodeForVariable(variableholder.variable)
        ctx.makeDataDependency(node, ctx.lastControlNode)
    }

    override fun visit(n: NormalAnnotationExpr, ctx: BuilderContext) {}

    override fun visit(n: NullLiteralExpr, ctx: BuilderContext) {}

    override fun visit(n: ObjectCreationExpr, ctx: BuilderContext) {
        for (arg in n.arguments)
            arg.accept(this, ctx)
    }

    override fun visit(n: PackageDeclaration, ctx: BuilderContext) {}

    override fun visit(n: Parameter, ctx: BuilderContext) {
        ctx.makeControlDependency(ctx.lastControlNode, ctx.declareLocal(n.nameAsString))
    }

    override fun visit(n: PrimitiveType, ctx: BuilderContext) {}

    override fun visit(n: ReturnStmt, ctx: BuilderContext) {
        val node = ctx.getGraphNodeForTreeNode(n)
        ctx.makeControlDependency(ctx.lastControlNode, node)
        ctx.lastControlNode = node

        n.expression.ifPresent { it.accept(this, ctx) }
    }

    override fun visit(n: SimpleName, ctx: BuilderContext) {
        val variableholder = ctx.lookupOrCreateVariableByName(n.asString())
        val node = ctx.getGraphNodeForVariable(variableholder.variable)
        ctx.makeDataDependency(node, ctx.lastControlNode)
    }

    override fun visit(n: SingleMemberAnnotationExpr, ctx: BuilderContext) {}

    override fun visit(n: StringLiteralExpr, ctx: BuilderContext) {}

    override fun visit(n: SuperExpr, ctx: BuilderContext) {}

    override fun visit(n: SwitchEntry, ctx: BuilderContext) {}

    override fun visit(n: SwitchStmt, ctx: BuilderContext) {
        val node = ctx.getGraphNodeForTreeNode(n, "switch (${n.selector})")
        ctx.makeControlDependency(ctx.lastControlNode, node)

        ctx.lastControlNode = node
        n.selector.accept(this, ctx)
        n.entries.forEach { it.accept(this, ctx) }
    }

    override fun visit(n: SynchronizedStmt, ctx: BuilderContext) {
        val node = ctx.getGraphNodeForTreeNode(n, "synchronized (${n.expression})")
        ctx.makeControlDependency(ctx.lastControlNode, node)

        ctx.lastControlNode = node
        n.expression.accept(this, ctx)
        n.body.accept(this, ctx)
    }

    override fun visit(n: ThisExpr, ctx: BuilderContext) {}

    override fun visit(n: ThrowStmt, ctx: BuilderContext) {
        val node = ctx.getGraphNodeForTreeNode(n)
        ctx.makeControlDependency(ctx.lastControlNode, node)
        ctx.lastControlNode = node

        n.expression.accept(this, ctx)
    }

    override fun visit(n: TryStmt, ctx: BuilderContext) {
        val node = ctx.getGraphNodeForTreeNode(n, "try")
        ctx.makeControlDependency(ctx.lastControlNode, node)

        ctx.lastControlNode = node
        n.resources.accept(this, ctx)

        for (catch in n.catchClauses) {
            ctx.lastControlNode = node
            catch.accept(this, ctx)
        }

        n.finallyBlock.ifPresent {
            ctx.lastControlNode = node
            it.accept(this, ctx)
        }
    }

    override fun visit(n: TypeExpr, ctx: BuilderContext) {}
    override fun visit(n: TypeParameter, ctx: BuilderContext) {}

    override fun visit(n: UnaryExpr, ctx: BuilderContext) {
        n.expression.accept(this, ctx)
    }

    override fun visit(n: UnionType, ctx: BuilderContext) {}
    override fun visit(n: UnknownType, ctx: BuilderContext) {}

    override fun visit(n: VariableDeclarationExpr, ctx: BuilderContext) {
        n.variables.forEach { it.accept(this, ctx) }
    }

    override fun visit(n: VariableDeclarator, ctx: BuilderContext) {
        val node = ctx.declareLocal(n.nameAsString)
        ctx.makeControlDependency(ctx.lastControlNode, node)
    }

    override fun visit(n: VoidType, ctx: BuilderContext) {}

    override fun visit(n: WhileStmt, ctx: BuilderContext) {
        val node = ctx.getGraphNodeForTreeNode(n, "while (${n.condition})")
        ctx.makeControlDependency(ctx.lastControlNode, node)

        ctx.lastControlNode = node
        n.condition.accept(this, ctx)
        n.body.accept(this, ctx)
    }

    override fun visit(n: WildcardType, ctx: BuilderContext) {}
    override fun visit(n: ReceiverParameter, ctx: BuilderContext) {}
    override fun visit(n: VarType, ctx: BuilderContext) {}

    override fun visit(switchExpr: SwitchExpr, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: TextBlockLiteralExpr, ctx: BuilderContext) {}

    override fun visit(yieldStmt: YieldStmt, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: UnparsableStmt, ctx: BuilderContext) {}

    override fun visit(n: Modifier, ctx: BuilderContext) {}

    override fun visit(n: ModuleDeclaration, ctx: BuilderContext) {}
    override fun visit(n: ModuleRequiresDirective, ctx: BuilderContext) {}
    override fun visit(n: ModuleExportsDirective, ctx: BuilderContext) {}
    override fun visit(n: ModuleProvidesDirective, ctx: BuilderContext) {}
    override fun visit(n: ModuleUsesDirective, ctx: BuilderContext) {}
    override fun visit(n: ModuleOpensDirective, ctx: BuilderContext) {}

    override fun visit(n: JavadocBlockTag, ctx: BuilderContext) {}
    override fun visit(n: JavadocContent, ctx: BuilderContext) {}
    override fun visit(n: JavadocDescription, ctx: BuilderContext) {}
    override fun visit(n: JavadocInlineTag, ctx: BuilderContext) {}
    override fun visit(n: JavadocSnippet, ctx: BuilderContext) {}
}