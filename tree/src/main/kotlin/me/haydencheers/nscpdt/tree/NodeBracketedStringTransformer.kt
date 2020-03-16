package me.haydencheers.nscpdt.tree

import com.github.javaparser.ast.*
import com.github.javaparser.ast.body.*
import com.github.javaparser.ast.expr.*
import com.github.javaparser.ast.stmt.*
import com.github.javaparser.ast.type.*
import com.github.javaparser.ast.visitor.VoidVisitorAdapter

object NodeBracketedStringTransformer {
    fun transform(node: Node): String {
        val builder = StringBuilder()

//        builder.append("{")
        node.accept(BSTransformerVisitor2, builder)
//        builder.append("}")

        return builder.toString()
    }

    private object BSTransformerVisitor2 : VoidVisitorAdapter<StringBuilder>() {
        override fun visit(n: AnnotationDeclaration, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: AnnotationMemberDeclaration, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: ArrayAccessExpr, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: ArrayCreationExpr, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: ArrayInitializerExpr, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: AssertStmt, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: AssignExpr, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: BinaryExpr, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: BlockStmt, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: BooleanLiteralExpr, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: BreakStmt, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: CastExpr, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: CatchClause, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: CharLiteralExpr, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: ClassExpr, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: ClassOrInterfaceDeclaration, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: ClassOrInterfaceType, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: CompilationUnit, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: ConditionalExpr, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: ConstructorDeclaration, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: ContinueStmt, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: DoStmt, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: DoubleLiteralExpr, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: EmptyStmt, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: EnclosedExpr, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: EnumConstantDeclaration, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: EnumDeclaration, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: ExplicitConstructorInvocationStmt, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: ExpressionStmt, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: FieldAccessExpr, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: FieldDeclaration, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: ForEachStmt, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: ForStmt, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: IfStmt, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: InitializerDeclaration, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: InstanceOfExpr, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: IntegerLiteralExpr, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: LabeledStmt, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: LongLiteralExpr, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: MarkerAnnotationExpr, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: MemberValuePair, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: MethodCallExpr, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: MethodDeclaration, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: NameExpr, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: NormalAnnotationExpr, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: NullLiteralExpr, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: ObjectCreationExpr, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: PackageDeclaration, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: Parameter, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: PrimitiveType, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: Name, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: SimpleName, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: ArrayType, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: ArrayCreationLevel, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: IntersectionType, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: UnionType, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: ReturnStmt, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: SingleMemberAnnotationExpr, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: StringLiteralExpr, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: SuperExpr, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: SwitchEntry, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: SwitchStmt, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: SynchronizedStmt, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: ThisExpr, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: ThrowStmt, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: TryStmt, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: LocalClassDeclarationStmt, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: TypeParameter, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: UnaryExpr, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: UnknownType, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: VariableDeclarationExpr, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: VariableDeclarator, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: VoidType, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: WhileStmt, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: WildcardType, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: LambdaExpr, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: MethodReferenceExpr, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: TypeExpr, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: NodeList<*>, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: ImportDeclaration, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: UnparsableStmt, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: ReceiverParameter, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: VarType, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: SwitchExpr, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: TextBlockLiteralExpr, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }

        override fun visit(n: YieldStmt, arg: StringBuilder) {
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
        }
    }

    /*
            arg.append("{")
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                it.accept(this, arg)
            }
            arg.append("}")
     */

    private class BSTransformerVisitor : VoidVisitorAdapter<StringBuilder>() {
        override fun visit(n: AnnotationDeclaration, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: AnnotationMemberDeclaration, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: ArrayAccessExpr, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: ArrayCreationExpr, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: ArrayInitializerExpr, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: AssertStmt, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: AssignExpr, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: BinaryExpr, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

//        override fun visit(n: BlockComment, arg: StringBuilder) {
//            arg.append(n.javaClass.simpleName)
//            n.childNodes.forEach {
//                arg.append("{")
//                it.accept(this, arg)
//                arg.append("}")
//            }
//        }

        override fun visit(n: BlockStmt, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: BooleanLiteralExpr, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: BreakStmt, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: CastExpr, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: CatchClause, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: CharLiteralExpr, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: ClassExpr, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: ClassOrInterfaceDeclaration, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: ClassOrInterfaceType, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: CompilationUnit, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: ConditionalExpr, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: ConstructorDeclaration, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: ContinueStmt, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: DoStmt, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: DoubleLiteralExpr, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: EmptyStmt, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: EnclosedExpr, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: EnumConstantDeclaration, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: EnumDeclaration, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: ExplicitConstructorInvocationStmt, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: ExpressionStmt, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: FieldAccessExpr, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: FieldDeclaration, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: ForEachStmt, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: ForStmt, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: IfStmt, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: InitializerDeclaration, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: InstanceOfExpr, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: IntegerLiteralExpr, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

//        override fun visit(n: JavadocComment, arg: StringBuilder) {
//            arg.append(n.javaClass.simpleName)
//            n.childNodes.forEach {
//                arg.append("{")
//                it.accept(this, arg)
//                arg.append("}")
//            }
//        }

        override fun visit(n: LabeledStmt, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

//        override fun visit(n: LineComment, arg: StringBuilder) {
//            arg.append(n.javaClass.simpleName)
//            n.childNodes.forEach {
//                arg.append("{")
//                it.accept(this, arg)
//                arg.append("}")
//            }
//        }

        override fun visit(n: LongLiteralExpr, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: MarkerAnnotationExpr, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: MemberValuePair, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: MethodCallExpr, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: MethodDeclaration, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: NameExpr, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: NormalAnnotationExpr, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: NullLiteralExpr, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: ObjectCreationExpr, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: PackageDeclaration, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: Parameter, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: PrimitiveType, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: Name, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: SimpleName, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: ArrayType, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: ArrayCreationLevel, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: IntersectionType, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: UnionType, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: ReturnStmt, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: SingleMemberAnnotationExpr, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: StringLiteralExpr, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: SuperExpr, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: SwitchEntry, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: SwitchStmt, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: SynchronizedStmt, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: ThisExpr, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: ThrowStmt, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: TryStmt, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: LocalClassDeclarationStmt, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: TypeParameter, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: UnaryExpr, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: UnknownType, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: VariableDeclarationExpr, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: VariableDeclarator, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: VoidType, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: WhileStmt, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: WildcardType, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: LambdaExpr, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: MethodReferenceExpr, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: TypeExpr, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: NodeList<*>, arg: StringBuilder) {
            n.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: ImportDeclaration, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

//        override fun visit(n: ModuleDeclaration, arg: StringBuilder) {
//            arg.append(n.javaClass.simpleName)
//            n.childNodes.forEach {
//                arg.append("{")
//                it.accept(this, arg)
//                arg.append("}")
//            }
//        }

//        override fun visit(n: ModuleRequiresDirective, arg: StringBuilder) {
//            arg.append(n.javaClass.simpleName)
//            n.childNodes.forEach {
//                arg.append("{")
//                it.accept(this, arg)
//                arg.append("}")
//            }
//        }

//        override fun visit(n: ModuleExportsDirective, arg: StringBuilder) {
//            arg.append(n.javaClass.simpleName)
//            n.childNodes.forEach {
//                arg.append("{")
//                it.accept(this, arg)
//                arg.append("}")
//            }
//        }

//        override fun visit(n: ModuleProvidesDirective, arg: StringBuilder) {
//            arg.append(n.javaClass.simpleName)
//            n.childNodes.forEach {
//                arg.append("{")
//                it.accept(this, arg)
//                arg.append("}")
//            }
//        }

//        override fun visit(n: ModuleUsesDirective, arg: StringBuilder) {
//            arg.append(n.javaClass.simpleName)
//            n.childNodes.forEach {
//                arg.append("{")
//                it.accept(this, arg)
//                arg.append("}")
//            }
//        }

//        override fun visit(n: ModuleOpensDirective, arg: StringBuilder) {
//            arg.append(n.javaClass.simpleName)
//            n.childNodes.forEach {
//                arg.append("{")
//                it.accept(this, arg)
//                arg.append("}")
//            }
//        }

        override fun visit(n: UnparsableStmt, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: ReceiverParameter, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: VarType, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

//        override fun visit(n: Modifier, arg: StringBuilder) {
//            arg.append(n.javaClass.simpleName)
//            n.childNodes.forEach {
//                arg.append("{")
//                it.accept(this, arg)
//                arg.append("}")
//            }
//        }

        override fun visit(n: SwitchExpr, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: TextBlockLiteralExpr, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

        override fun visit(n: YieldStmt, arg: StringBuilder) {
            arg.append(n.javaClass.simpleName)
            n.childNodes.forEach {
                arg.append("{")
                it.accept(this, arg)
                arg.append("}")
            }
        }

//        override fun visit(n: JavadocBlockTag, arg: StringBuilder) {
//            arg.append(n.javaClass.simpleName)
//            n.childNodes.forEach {
//                arg.append("{")
//                it.accept(this, arg)
//                arg.append("}")
//            }
//        }

//        override fun visit(n: JavadocContent, arg: StringBuilder) {
//            arg.append(n.javaClass.simpleName)
//            n.childNodes.forEach {
//                arg.append("{")
//                it.accept(this, arg)
//                arg.append("}")
//            }
//        }

//        override fun visit(n: JavadocDescription, arg: StringBuilder) {
//            arg.append(n.javaClass.simpleName)
//            n.childNodes.forEach {
//                arg.append("{")
//                it.accept(this, arg)
//                arg.append("}")
//            }
//        }

//        override fun visit(n: JavadocInlineTag, arg: StringBuilder) {
//            arg.append(n.javaClass.simpleName)
//            n.childNodes.forEach {
//                arg.append("{")
//                it.accept(this, arg)
//                arg.append("}")
//            }
//        }

//        override fun visit(n: JavadocSnippet, arg: StringBuilder) {
//            arg.append(n.javaClass.simpleName)
//            n.childNodes.forEach {
//                arg.append("{")
//                it.accept(this, arg)
//                arg.append("}")
//            }
//        }
    }
}