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

    override fun visit(n: BlockComment, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: BlockStmt, ctx: BuilderContext) {
        ctx.pushScope()
        n.statements.accept(this, ctx)
        ctx.popScope()
    }

    override fun visit(n: BooleanLiteralExpr, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: BreakStmt, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: CastExpr, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: CatchClause, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: CharLiteralExpr, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: ClassExpr, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: ClassOrInterfaceDeclaration, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: ClassOrInterfaceType, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: CompilationUnit, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: ConditionalExpr, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: DoStmt, ctx: BuilderContext) {



        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: DoubleLiteralExpr, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: EmptyStmt, ctx: BuilderContext) {}

    override fun visit(n: EnclosedExpr, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: EnumConstantDeclaration, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: EnumDeclaration, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: ExplicitConstructorInvocationStmt, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: ExpressionStmt, ctx: BuilderContext) {
        val node = ctx.getGraphNodeForTreeNode(n)
        ctx.makeControlDependency(ctx.lastControlNode, node)

        ctx.lastControlNode = node
        n.expression.accept(this, ctx)
    }

    override fun visit(n: FieldAccessExpr, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: FieldDeclaration, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: ForStmt, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: ForEachStmt, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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

    override fun visit(n: ImportDeclaration, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: InitializerDeclaration, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: InstanceOfExpr, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: IntegerLiteralExpr, ctx: BuilderContext) {}

    override fun visit(n: IntersectionType, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: JavadocComment, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: LabeledStmt, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: LambdaExpr, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: LineComment, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: LocalClassDeclarationStmt, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: LongLiteralExpr, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: MarkerAnnotationExpr, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: MemberValuePair, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: NameExpr, ctx: BuilderContext) {
        val variableholder = ctx.lookupOrCreateVariableByName(n.nameAsString)
        val node = ctx.getGraphNodeForVariable(variableholder.variable)
        ctx.makeDataDependency(node, ctx.lastControlNode)
    }

    override fun visit(n: Name, ctx: BuilderContext) {

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: NormalAnnotationExpr, ctx: BuilderContext) {



        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: NullLiteralExpr, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: ObjectCreationExpr, ctx: BuilderContext) {
        for (arg in n.arguments)
            arg.accept(this, ctx)
    }

    override fun visit(n: PackageDeclaration, ctx: BuilderContext) {}

    override fun visit(n: Parameter, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: PrimitiveType, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: ReturnStmt, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: SimpleName, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: SingleMemberAnnotationExpr, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: StringLiteralExpr, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: SuperExpr, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: SwitchEntry, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: SwitchStmt, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: SynchronizedStmt, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: ThisExpr, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: ThrowStmt, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: TryStmt, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: TypeExpr, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: TypeParameter, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: UnaryExpr, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: UnionType, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: UnknownType, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: VariableDeclarationExpr, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: VariableDeclarator, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: VoidType, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: WhileStmt, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: WildcardType, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: ReceiverParameter, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: VarType, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(switchExpr: SwitchExpr, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: TextBlockLiteralExpr, ctx: BuilderContext) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

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