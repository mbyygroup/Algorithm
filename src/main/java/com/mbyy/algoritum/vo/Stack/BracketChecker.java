package com.mbyy.algoritum.vo.Stack;

public class BracketChecker {
    private String input;
    public BracketChecker(String in){
        input=in;
    }
    public void check(){
        int stackSize=input.length();
        StackX theStack=new StackX(stackSize);
        for (int j=0;j<input.length();j++){
            char ch=input.charAt(j);
            switch (ch){
                case '{':
                    theStack.push(ch);
                    break;
                case '[':
                    theStack.push(ch);
                    break;
                case '(':
                    theStack.push(ch);
                    break;
                case '}':
                    if (!theStack.isEmpty()){
                        char chx= (char) theStack.pop();
                        if ((ch=='}'&&chx!='{')||
                                (ch==']'&&chx!='[')||
                                (ch==')'&&chx!='(')){
                            System.out.println("Error:"+ch+" at "+j);
                        }
                    }else {
                        System.out.println("Error: "+ch+" at "+j);
                    }
                    break;
                case ']':
                    if (!theStack.isEmpty()){
                        char chx= (char) theStack.pop();
                        if ((ch=='}'&&chx!='{')||
                                (ch==']'&&chx!='[')||
                                (ch==')'&&chx!='(')){
                            System.out.println("Error:"+ch+" at "+j);
                        }
                    }else {
                        System.out.println("Error: "+ch+" at "+j);
                    }
                    break;
                case ')':
                    if (!theStack.isEmpty()){
                        char chx= (char) theStack.pop();
                        if ((ch=='}'&&chx!='{')||
                            (ch==']'&&chx!='[')||
                            (ch==')'&&chx!='(')){
                            System.out.println("Error:"+ch+" at "+j);
                        }
                    }else {
                        System.out.println("Error: "+ch+" at "+j);
                    }
                    break;
                 default:
                     break;
            }
        }
        if (!theStack.isEmpty()){
            System.out.println("Error:missing right");
        }
    }

    //高级算法
    public boolean isValid(String input){
        int length;
        do {
            length=input.length();
            input=input.replace("{}","").replace("()","").replace("[]","");
        }while (length!=input.length());
        return input.length()==0;
    }

}
