import ast.*;

public class CompoundStatement extends AbstractNode 
{
    public Statement sNode = new Statement();

    public void setStatement(Statement s)
    {
        sNode = s;
    }
    
    public Statement getStatement()
    {
        return sNode;
    }

    public <RetType,ArgType> RetType accept(final AbstractVisitor<RetType, ArgType> v, final ArgType arg) 
    {
        v.visit(this, null);
        return null;
    }
}