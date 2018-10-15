import ast.*;

public class ParenthesisFactor extends AbstractNode 
{
    public Expression eNode = new Expression();

    public void setExpression(Expression e)
    {
        eNode = e;
    }
    
    public Expression getExpression()
    {
        return eNode;
    }

    public <RetType,ArgType> RetType accept(final AbstractVisitor<RetType, ArgType> v, final ArgType arg) 
    {
        v.visit(this, null);
        return null;
    }
}