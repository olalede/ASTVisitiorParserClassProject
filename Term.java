import ast.*;

public class Term extends AbstractNode 
{
    public Factor fNode = new Factor();

    public void setFactor(Factor f)
    {
        fNode = f;
    }
    
    public Factor getFactor()
    {
        return fNode;
    }

    public <RetType,ArgType> RetType accept(final AbstractVisitor<RetType, ArgType> v, final ArgType arg) 
    {
        v.visit(this, null);
        return null;
    }
}