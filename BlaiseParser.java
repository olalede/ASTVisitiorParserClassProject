import java.io.File;

import ast.*;

import blaise.parser.BlaiseLexer;

import org.antlr.v4.runtime.ANTLRFileStream;

import org.antlr.v4.runtime.Token;


public class BlaiseParser
{
    private BlaiseLexer lexer;

    public BlaiseParser(final BlaiseLexer lexer)
    {
		this.lexer = lexer;
    }

    Token next = lexer.nextToken();




public void consume()
{
    next = lexer.nextToken();
}

public Program parseProgram ()
{
    Program node = new Program();
    if (next.getText() == "VAR" || next.getText() == "ID" || next.getText() == "CALL" || next.getText() ==  "BEGIN" || next.getText() ==  "IF" || next.getText() ==  "WHILE") {
        node.setBlock(parseBlock());
        consume(/*DOT*/); 
        consume(/*EOF*/);
    }
    else
        return null;

    return node;
}

public Block parseBlock ()
{
    Block node = new Block();
    if (next.getText() ==  "VAR") {
      node.setVariables(parseVariables()); 
      parseBlock();
    }
    else if (next.getText() ==  "PROCEDEURE") {
        node.setProcedures(parseProcedures()); 
        parseBlock();
    }
    else if (next.getText() ==  "ID" || next.getText() ==  "CALL" || next.getText() ==  "BEGIN" || next.getText() ==  "IF" || next.getText() ==  "WHILE")
    {
        node.setStatement(parseStatement());
    }
    else
        return null;

    return node;
}

public Variables parseVariables()
{
    Variables node = new Variables();
    if (next.getText() ==  "VAR") {
        consume(/*VAR*/); 
        node.setVariableDeclaration(parseVariableDeclaration()); 
        parseVariables();
    }
    else if (next.getText() ==  "COMMA") {
        consume(/*COMMA*/); 
        node.setVariableDeclaration(parseVariableDeclaration());  
        parseVariables();
    }
    else if (next.getText() ==  "SEMICOLON")
        consume(/*SEMICOLON*/);
    else
        return null;

    return node;
}

public VariableDeclaration parseVariableDeclaration()
{
    VariableDeclaration node = new VariableDeclaration();
    if (next.getText() ==  "ID")
        consume(/*ID*/);
    else
        return null;

    return node;
}

public Procedures parseProcedures()
{
    Procedures node = new Procedures();
    if (next.getText() ==  "PROCEDEURE") 
    {
        while (next.getText() ==  "PROCEDEURE")
            node.setProcedureDeclaration(parseProcedureDeclaration()); 
    }
    else
        return null;

    return node;
}

public ProcedureDeclaration parseProcedureDeclaration()
{
    ProcedureDeclaration node = new ProcedureDeclaration();
    if (next.getText() ==  "PROCEDEURE") {
        consume(/*PROCEDEURE*/); 
        consume(/*ID*/); 
        consume(/*LPAREN*/); 
        parseProcedureDeclaration();
    }
    else if (next.getText() ==  "ID") {
        node.setFormalParemeters(parseFormalParameters()); 
        parseProcedureDeclaration();
    }
    else if (next.getText() ==  "RPAREN") {
        consume(/*RPAREN*/); 
        node.setBlock(parseBlock());
        consume(/*SEMICOLON*/);
    }
    else 
        return null;

    return node;
}

public FormalParameters parseFormalParameters ()
{
    FormalParameters node = new FormalParameters();
    if (next.getText() ==  "ID")
    {
        node.setVariableDeclaration(parseVariableDeclaration()); 
        if (next.getText() ==  "COMMA") {
            consume(/*COMMMA*/); 
            parseFormalParameters();
        }
    }
    else 
        return null;

    return node;
}

public Statement parseStatement()
 {
    Statement node = new Statement();

    if (next.getText() ==  "ID")
        node.setAssignmentStatement(parseAssignmentStatement()); 
    else if (next.getText() ==  "CALL")
        node.setCallStatement(parseCallStatement()); 
    else if (next.getText() ==  "BEGIN")
        node.setCompoundStatement(parseCompoundStatement()); 
    else if (next.getText() ==  "IF")
        node.setIfStatement(parseIfStatement()); 
    else if (next.getText() ==  "WHILE")
        node.setWhileStatement(parseWhileStatement());
    else 
    return null;

    return node;
 }

 public AssignmentStatement parseAssignmentStatement()
 {
     AssignmentStatement node = new AssignmentStatement();

    if (next.getText() == "ID") { 
        consume(/*ID*/); 
        consume (/*ASSIGN*/); 
        node.setExpression(parseExpression());
    }
    else 
    return null;

    return node;
 }

 public CallStatement parseCallStatement()
 {
    CallStatement node = new CallStatement();

    if (next.getText() ==  "CALL") { 
        consume(/*CALL*/); 
        consume(/*ID*/); 
        consume(/*LPAREN*/); 
        parseCallStatement();
    }
    else if (next.getText() ==  "ID" || next.getText() ==  "NUMBER" || next.getText() ==  "LPAREN") {
        node.setActualParameters(parseActualParameters()); 
        parseCallStatement();
    }
    else if (next.getText() ==  "RPAREN")
        consume(/*RPAREN*/); 
    else 
    return null;

    return node;
 }

 public ActualParameters parseActualParameters()
 {
    ActualParameters node = new ActualParameters();

    if (next.getText() ==  "ID" || next.getText() ==  "NUMBER" || next.getText() ==  "LPAREN") {
        node.setExpression(parseExpression()); 
        if (next.getText() ==  "COMMA") {
            consume(/*COMMMA*/); 
            parseActualParameters(); 
        }
    }
    else 
    return null;

    return node;
 }

 public CompoundStatement parseCompoundStatement()
 {
     CompoundStatement node = new CompoundStatement();

    if (next.getText() ==  "BEGIN") { 
        consume(/*BEGIN*/); 
        node.setStatement(parseStatement()); 
        parseCompoundStatement(); 
    }
    else if (next.getText() ==  "SEMICOLON") {
        consume(/*SEMICOLON*/); 
        parseCompoundStatement();
    }
    else if (next.getText() ==  "ID" || next.getText() ==  "CALL" || next.getText() ==  "IF" || next.getText() ==  "WHILE") {
        node.setStatement(parseStatement()); 
        parseCompoundStatement();
    }
    else if (next.getText() ==  "END")
        consume(/*END*/);
    else
        return null;

        return node;
 }

 public IfStatement parseIfStatement()
 {
     IfStatement node = new IfStatement();

    if (next.getText() ==  "IF") { 
      consume(/*IF*/); 
      node.setCondition(parseCondition()); 
      consume(/*THEN*/); 
      node.setStatement(parseStatement()); 
      consume(/*ELSE*/); 
      node.setStatement(parseStatement());
    }
    else 
    return null;

    return node;
 }

 public WhileStatement parseWhileStatement()
 {
     WhileStatement node = new WhileStatement();

    if (next.getText() ==  "WHILE") { 
        consume(/*WHILE*/); 
        node.setCondition(parseCondition()); 
        consume(/*DO*/); 
        node.setStatement(parseStatement());
    }
    else 
    return null;

    return node;
 }

 public Condition parseCondition()
 {
    Condition node = new Condition();

    if (next.getText() ==  "ID" || next.getText() ==  "NUMBER" || next.getText() ==  "LPAREN")
    {
        node.setExpression(parseExpression());
        if (next.getText() ==  "EQ" || next.getText() ==  "NE" || next.getText() ==  "LT" || next.getText() ==  "LTE" || next.getText() ==  "GT" || next.getText() ==  "GTE")
        {
            if (next.getText() ==  "EQ") {
                consume(/*EQ*/); 
                parseCondition();
            }
            else if (next.getText() ==  "NE") {
                consume(/*NE*/); 
                parseCondition();
            }
            else if (next.getText() ==  "LT") {
                consume(/*LT*/); 
                parseCondition();
            }
            else if (next.getText() ==  "LTE") {
                consume(/*LTE*/); 
                parseCondition();
            }
            else if (next.getText() ==  "GT") {
                consume(/*GT*/); 
                parseCondition();
            }
            else if (next.getText() ==  "GTE") {
                consume(/*GTE*/); 
                parseCondition();
            }
        }
    }
    else 
    return null;

    return node;
 }

 public Expression parseExpression()
 {
     Expression node = new Expression();
    if (next.getText() ==  "ID" || next.getText() ==  "NUMBER" || next.getText() ==  "LPAREN")
    {
       node.setTerm(parseTerm());
        if (next.getText() ==  "PLUS" || next.getText() ==  "MINUS")
        {
            if (next.getText() ==  "PLUS") {
                consume(/*PLUS*/); 
                parseExpression();
            }
            else if (next.getText() ==  "MINUS") {
                consume(/*MINUS*/); 
                parseExpression(); 
            }
        }
    }
    else 
    return null;

    return node;
 }

public Term parseTerm()
{
    Term node = new Term();
    if (next.getText() ==  "ID" || next.getText() ==  "NUMBER" || next.getText() ==  "LPAREN") 
    {
        node.setFactor(parseFactor());
        if (next.getText() ==  "MULT" || next.getText() ==  "DIV")
        {
            if (next.getText() ==  "MULT") {
               consume(/*MULT*/);
               parseTerm();
            }
            else if (next.getText() ==  "DIV") {
                consume(/*DIV*/); 
                parseTerm();
            }
        }
    }
    else 
    return null;

    return node;
}

public Factor parseFactor()
{
    Factor node = new Factor();
    if (next.getText() ==  "ID")
    {
        consume(/*ID*/);
    }
    else if (next.getText() ==  "NUMBER")
    {
        consume(/*NUMBER*/);
    }
    else if (next.getText() ==  "LPAREN")
    {
    node.setParenthesisFactor(parseParenthesisFactor());
    }
    else 
    return null;

    return node;
}

public ParenthesisFactor parseParenthesisFactor()
{
    ParenthesisFactor node = new ParenthesisFactor();

    if (next.getText() ==  "LPAREN") { 
        consume(/*LPAREN*/); 
        node.setExpression(parseExpression()); 
        consume(/*RPAREN*/);
    }
    else
    return null;

    return node;
}
}