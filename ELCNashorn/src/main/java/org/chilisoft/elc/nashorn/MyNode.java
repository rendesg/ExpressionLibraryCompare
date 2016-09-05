package org.chilisoft.elc.nashorn;

/**
 * Created by TothPeter on 2016. 09. 05..
 */
public class MyNode {


    private String method;

    private String variableName;

    private MyNode leftNode;
    private MyNode rightNode;

    public MyNode () {
        this.method = null;
        this.variableName = "";
        this.leftNode = null;
        this.rightNode = null;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    public MyNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(MyNode leftNode) {
        this.leftNode = leftNode;
    }

    public MyNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(MyNode rightNode) {
        this.rightNode = rightNode;
    }

    public String toString() {
        String retval = "";
        if (this.leftNode == null) {
            if (this.rightNode == null) {
                return this.variableName;
            } else {
                // Ilyen nincs!?
            }
        } else {
            if (this.rightNode == null) {
                return this.method + this.leftNode.toString();
            } else {
                if (method.equals("+")) {
                    retval += "add(" + this.leftNode.toString()+ "," + this.rightNode.toString() + ")";
                } else if (method.equals("-") || method.equals("||")){
                    retval += "(" + this.leftNode.toString()+ this.method + this.rightNode.toString() + ")";
                } else if (method.equals("==")) {
                    retval += "equals(" + this.leftNode.toString()+ "," + this.rightNode.toString() + ")";
                } else if (method.equals("!=")) {
                    retval += "!equals(" + this.leftNode.toString()+ "," + this.rightNode.toString() + ")";
                } else {
                    retval += this.leftNode.toString()+ this.method + this.rightNode.toString();
                }
            }
        }
        return retval;
    }

}
