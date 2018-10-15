import ast.*;

public class IfStatement extends AbstractNode 
{
    public Condition cNode = new Condition();
    public Statement sNode  = new Statement();

    public void setCondition(Condition c)
    {
        cNode = c;
    }
    
    public Condition getCondition()
    {
        return cNode;
    }

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