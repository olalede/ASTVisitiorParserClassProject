import ast.*;

public class Statement extends AbstractNode 
{
    public AssignmentStatement asNode = new AssignmentStatement();
    public CallStatement csNode = new CallStatement();
    public CompoundStatement compNode = new CompoundStatement();
    public IfStatement isNode = new IfStatement();
    public WhileStatement wsNode = new WhileStatement();

    public void setAssignmentStatement(AssignmentStatement as)
    {
        asNode = as;
    }
    
    public AssignmentStatement getAssignmentStatement()
    {
        return asNode;
    }

    public void setCallStatement(CallStatement cs)
    {
        csNode = cs;
    }
    
    public CallStatement getCallStatement()
    {
        return csNode;
    }

    public void setCompoundStatement(CompoundStatement comp)
    {
        compNode = comp;
    }
    
    public CompoundStatement getCompoundStatement()
    {
        return compNode;
    }

    public void setIfStatement(IfStatement is)
    {
        isNode = is;
    }
    
    public IfStatement getIfStatement()
    {
        return isNode;
    }

    public void setWhileStatement(WhileStatement ws)
    {
        wsNode = ws;
    }
    
    public WhileStatement getWhileStatement()
    {
        return wsNode;
    }

    public <RetType,ArgType> RetType accept(final AbstractVisitor<RetType, ArgType> v, final ArgType arg) 
    {
        v.visit(this, null);
        return null;
    }
}