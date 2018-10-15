import ast.*;

public class CallStatement extends AbstractNode 
{
    public ActualParameters apNode = new ActualParameters();

    public void setActualParameters(ActualParameters ap)
    {
        apNode = ap;
    }
    
    public ActualParameters getActualParameters()
    {
        return apNode;
    }

    public <RetType,ArgType> RetType accept(final AbstractVisitor<RetType, ArgType> v, final ArgType arg) 
    {
        v.visit(this, null);
        return null;
    }
}