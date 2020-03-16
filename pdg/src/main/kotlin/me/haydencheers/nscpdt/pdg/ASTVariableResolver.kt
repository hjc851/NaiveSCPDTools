package me.haydencheers.nscpdt.pdg

import com.github.javaparser.ast.*
import com.github.javaparser.ast.body.*
import com.github.javaparser.ast.comments.*
import com.github.javaparser.ast.expr.*
import com.github.javaparser.ast.modules.*
import com.github.javaparser.ast.stmt.*
import com.github.javaparser.ast.type.*
import com.github.javaparser.ast.visitor.GenericVisitor

object ASTVariableResolver: GenericVisitor<Variable?, BuilderContext> {
    override fun visit(n: CompilationUnit?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: PackageDeclaration?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: TypeParameter?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: LineComment?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: BlockComment?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: ClassOrInterfaceDeclaration?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: EnumDeclaration?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: EnumConstantDeclaration?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: AnnotationDeclaration?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: AnnotationMemberDeclaration?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: FieldDeclaration?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: VariableDeclarator?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: ConstructorDeclaration?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: MethodDeclaration?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: Parameter, arg: BuilderContext): Variable? {
        return Variable(n.nameAsString, VariableScope.LOCAL)
    }

    override fun visit(n: InitializerDeclaration?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: JavadocComment?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: ClassOrInterfaceType?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: PrimitiveType?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: ArrayType?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: ArrayCreationLevel?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: IntersectionType?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: UnionType?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: VoidType?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: WildcardType?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: UnknownType?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: ArrayAccessExpr?, arg: BuilderContext?): Variable? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: ArrayCreationExpr?, arg: BuilderContext?): Variable? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: ArrayInitializerExpr?, arg: BuilderContext?): Variable? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: AssignExpr?, arg: BuilderContext?): Variable? {
        return n?.target?.accept(this, arg)
    }

    override fun visit(n: BinaryExpr?, arg: BuilderContext?): Variable? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: CastExpr?, arg: BuilderContext?): Variable? {
        return n?.expression?.accept(this, arg)
    }

    override fun visit(n: ClassExpr?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: ConditionalExpr?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: EnclosedExpr?, arg: BuilderContext?): Variable? {
        return n?.inner?.accept(this, arg)
    }

    override fun visit(n: FieldAccessExpr?, arg: BuilderContext?): Variable? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: InstanceOfExpr?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: StringLiteralExpr?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: IntegerLiteralExpr?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: LongLiteralExpr?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: CharLiteralExpr?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: DoubleLiteralExpr?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: BooleanLiteralExpr?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: NullLiteralExpr?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: MethodCallExpr?, arg: BuilderContext?): Variable? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: NameExpr, arg: BuilderContext): Variable? {
        return arg.lookupOrCreateVariableByName(n.nameAsString).variable
    }

    override fun visit(n: ObjectCreationExpr?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: ThisExpr?, arg: BuilderContext?): Variable? {
        return Variable("this", VariableScope.LOCAL)
    }

    override fun visit(n: SuperExpr?, arg: BuilderContext?): Variable? {
        return Variable("this", VariableScope.LOCAL)
    }

    override fun visit(n: UnaryExpr?, arg: BuilderContext?): Variable? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(n: VariableDeclarationExpr, arg: BuilderContext): Variable? {
        return n.variables.first().accept(this, arg)
    }

    override fun visit(n: MarkerAnnotationExpr?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: SingleMemberAnnotationExpr?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: NormalAnnotationExpr?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: MemberValuePair?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: ExplicitConstructorInvocationStmt?, arg: BuilderContext?): Variable? {
        return Variable("this", VariableScope.LOCAL)
    }

    override fun visit(n: LocalClassDeclarationStmt?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: AssertStmt?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: BlockStmt?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: LabeledStmt?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: EmptyStmt?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: ExpressionStmt?, arg: BuilderContext?): Variable? {
        return n?.expression?.accept(this, arg)
    }

    override fun visit(n: SwitchStmt?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: SwitchEntry?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: BreakStmt?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: ReturnStmt?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: IfStmt?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: WhileStmt?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: ContinueStmt?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: DoStmt?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: ForEachStmt?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: ForStmt?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: ThrowStmt?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: SynchronizedStmt?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: TryStmt?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: CatchClause?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: LambdaExpr?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: MethodReferenceExpr?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: TypeExpr?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: NodeList<*>?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: Name, arg: BuilderContext): Variable {
        return arg.lookupOrCreateVariableByName(n.asString()).variable
    }

    override fun visit(n: SimpleName, arg: BuilderContext): Variable? {
        return arg.lookupOrCreateVariableByName(n.asString()).variable
    }

    override fun visit(n: ImportDeclaration?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: ModuleDeclaration?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: ModuleRequiresDirective?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: ModuleExportsDirective?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: ModuleProvidesDirective?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: ModuleUsesDirective?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: ModuleOpensDirective?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: UnparsableStmt?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: ReceiverParameter?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: VarType?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: Modifier?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: SwitchExpr?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: YieldStmt?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: TextBlockLiteralExpr?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: JavadocBlockTag?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: JavadocContent?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: JavadocDescription?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: JavadocInlineTag?, arg: BuilderContext?): Variable? {
        return null
    }

    override fun visit(n: JavadocSnippet?, arg: BuilderContext?): Variable? {
        return null
    }
}