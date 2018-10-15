import java.io.File;
import java.util.ArrayList;
import java.util.List;

import ast.*;


public class Project2Visitor extends AbstractVisitor<Void, Void> 
{
	private int indent = 0;

    private Void indent() 
    {
		for (int i = 0; i < indent; i++)
            System.out.print("    ");
            return null;
    }

    public Void visit(Program p, Void fd)
    {
        System.out.println("Program");
        if (p.getBlock() != null)
        {
            p.getBlock().accept(this, null);
        }
        return null;
    }
    public Void visit(Block b, Void fc)
    { 
        indent++;
        indent();
        System.out.println("Block");

        if (b.getVariables() != null)
        {
            b.getVariables().accept(this, null);
        }

        if (b.getProcedures() != null)
        {
            b.getProcedures().accept(this, null);
        }

        if (b.getStatement() != null)
        {
            b.getStatement().accept(this, null);
        }
        return null;
    }
    public Void visit(Variables v, Void fn)
    {
        indent++;
        indent();
        System.out.println("Variables");

        if (v.getVariableDeclaration() != null)
        {
            v.getVariableDeclaration().accept(this, null);
        }
        return null;
    }

    public Void visit(VariableDeclaration vd , Void fh)
    {
        indent++;
        indent();
        System.out.println("VariableDeclaration");

       return null;
    }

    public Void visit(Procedures p, Void gh)
    {
        indent++;
        indent();
        System.out.println("Procedure");

        if(p.getProcedureDeclaration() != null)
        {
            p.getProcedureDeclaration().accept(this, null);
        }
        return null;
    }

    public Void visit(ProcedureDeclaration pd, Void mh)
    {
        indent++;
        indent();
        System.out.println("ProcedureDeclaration");

        
        if (pd.getFormalParemeters() != null)
        {
            pd.getFormalParemeters().accept(this, null);
        }

        if (pd.getBlock() != null)
        {
            pd.getBlock().accept(this, null);
        }

        return null;
    }

    public Void visit(FormalParameters fp, Void gt)
    {

        indent++;
        indent();
        System.out.println("FormalParemters");

        if(fp.getVariableDeclaration() != null)
        {
            fp.getVariableDeclaration().accept(this, null);
        }
        return null;
    }

    public Void visit(Statement s, Void gr)
    {
        indent++;
        indent();
        System.out.println("Statement");

        if (s.getAssignmentStatement() != null)
        {
            s.getAssignmentStatement().accept(this, null);
        }

        if (s.getCallStatement() != null)
        {
            s.getCallStatement().accept(this, null);
        }

        if (s.getCompoundStatement() != null)
        {
            s.getCompoundStatement().accept(this, null);
        }

        if (s.getIfStatement() != null)
        {
            s.getIfStatement().accept(this, null);
        }

        if (s.getWhileStatement() != null)
        {
            s.getWhileStatement().accept(this, null);
        }

        return null;
    }
    public Void visit(AssignmentStatement as, Void ty)
    {
        indent++;
        indent();
        System.out.println("AssignmentStatement");

        if(as.getExpression() != null)
        {
            as.getExpression().accept(this,null);
        }

        return null;
    }

    public Void visit(CallStatement cs, Void gb)
    {
        indent++;
        indent();
        System.out.println("CallStatement");

        if(cs.getActualParameters() != null)
        {
            cs.getActualParameters().accept(this,null);
        }

        return null;
    }


    public Void visit(ActualParameters ap, Void er)
    {
        indent++;
        indent();
        System.out.println("ActualParameters");

        if(ap.getExpression() != null)
        {
            ap.getExpression().accept(this,null);
        }
        return null;
    }

    public Void visit(CompoundStatement cs, Void dr)
    {
        indent++;
        indent();
        System.out.println("CompoundStatement");

        if(cs.getStatement() != null)
        {
            cs.getStatement().accept(this,null);
        }
        return null;
    }
    public Void visit(IfStatement is, Void aq)
    {
        indent++;
        indent();
        System.out.println("IfStatement");

        if(is.getStatement() != null)
        {
            is.getStatement().accept(this,null);
        }
        return null;
    }

    public Void visit(WhileStatement ws, Void el)
    {
        indent++;
        indent();
        System.out.println("Condition");

        if(ws.getCondition() != null)
        {
            ws.getCondition().accept(this,null);
        }

        if(ws.getStatement() != null)
        {
            ws.getStatement().accept(this,null);
        }
        System.out.println("Statement");


        return null;
    }

    public Void visit(Condition c, Void sa)
    {
        indent++;
        indent();
        System.out.println("Condition");

        if(c.getExpression() != null)
        {
            c.getExpression().accept(this,null);
        }
        return null;
    }
    public Void visit(Expression e, Void lk)
    {
        indent++;
        indent();
        System.out.println("Expression");

        if(e.getTerm() != null)
        {
            e.getTerm().accept(this,null);
        }
        return null;
    }
    public Void visit(Term t, Void fg)
    {
        indent++;
        indent();
        System.out.println("Term");

        if(t.getFactor() != null)
        {
            t.getFactor().accept(this,null);
        }
        return null;
    }
    public Void visit(Factor f, Void ez)
    {
        indent++;
        indent();
        System.out.println("Factor");

        if(f.getParenthesisFactor() != null)
        {
            f.getParenthesisFactor().accept(this,null);
        }
        return null;
    }
    public Void visit(ParenthesisFactor pf, Void fp)
    {
        indent++;
        indent();
        System.out.println("Parenthesis");

        if(pf.getExpression() != null)
        {
            pf.getExpression().accept(this,null);
        }
        return null;
    }
}