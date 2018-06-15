package net.unicon.avus.implicitassertions;

import org.codehaus.groovy.ast.ASTNode;
import org.codehaus.groovy.ast.ClassNode;
import org.codehaus.groovy.control.CompilePhase;
import org.codehaus.groovy.control.SourceUnit;
import org.codehaus.groovy.transform.ASTTransformation;
import org.codehaus.groovy.transform.GroovyASTTransformation;

/**
 * Converts Services authnResponse statements to be "implicit" assert statements.
 *
 * Call code for this package was taken almost directly from the base class.
 */
@GroovyASTTransformation(phase = CompilePhase.CANONICALIZATION)
public class ImplicitAssertionsTransformation implements ASTTransformation {
    public void visit(ASTNode[] astNodes, SourceUnit sourceUnit) {
        for (ClassNode classNode : sourceUnit.getAST().getClasses()) {
            classNode.visitContents(new ImplicitAssertionsTransformationVisitor(sourceUnit));
        }
    }
}