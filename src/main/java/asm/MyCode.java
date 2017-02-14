package asm;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import static org.objectweb.asm.Opcodes.*;
import org.objectweb.asm.*;

public class MyCode{
public static byte[] execute() throws Exception {
ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
cw.visit(V1_7, ACC_PUBLIC, "asm/MyCode", null, "java/lang/Object", new String[]{});

{
MethodVisitor mv = cw.visitMethod(ACC_PUBLIC, "<init>", "(II)V" ,null, null);
mv.visitCode();
// Constructor
Label lConstructor0 = new Label();
mv.visitLabel(lConstructor0);
mv.visitVarInsn(ALOAD,0);
// Load "this" onto the stack

mv.visitMethodInsn(INVOKESPECIAL,// Invoke an instance method (non-virtual)
"java/lang/Object", // Class on which the method is defined
"<init>",// Name of the method
"()V",// Descriptor
false);// Is this class an interface?

Label lConstructor2 = new Label();
mv.visitLabel(lConstructor2);


mv.visitIincInsn(1, 2);
mv.visitInsn(RETURN);                     mv.visitLocalVariable("this", "Lasm/MyCode;", null, lConstructor0, lConstructor2, 0);
mv.visitLocalVariable("xx", "I", null, lConstructor0, lConstructor2, 1);
mv.visitLocalVariable("yy", "I", null, lConstructor0, lConstructor2, 2);
 // End the constructor method
mv.visitMaxs(0, 0);
mv.visitEnd();
}
   {
            /* Build 'method1' method */
            MethodVisitor mv = cw.visitMethod(
                    ACC_PUBLIC,                         // public method
                    "method1",                              // name
                    "(I)V",                            // descriptor
                    null,                               // signature (null means not generic)
                    null);                              // exceptions (array of strings)
mv.visitCode();

Label lMethod0 = new Label();
mv.visitLabel(lMethod0);

Label start60 = new Label();
mv.visitLabel(start60);
mv.visitVarInsn(ILOAD,1);
mv.visitLdcInsn(10);
Label l60 = new Label();
mv.visitJumpInsn(IF_ICMPGE, l60);

mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
mv.visitLdcInsn("Hello World!!!");
mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V");
mv.visitJumpInsn(GOTO, start60);
mv.visitLabel(l60);

mv.visitIincInsn(1, 1);
mv.visitInsn(RETURN);     
Label lMethod1 = new Label();
mv.visitLabel(lMethod1);
mv.visitLocalVariable("this", "Lasm/method1;", null, lMethod0, lMethod1, 0);
               // Return integer from top of stack
mv.visitLocalVariable("x", "I", null, lMethod0, lMethod1, 1);
  mv.visitMaxs(0, 0);
mv.visitEnd();
}

{
// Main Method
MethodVisitor mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
mv.visitCode();
Label lMethod0 = new Label();
mv.visitLabel(lMethod0);

mv.visitLdcInsn(new Integer(10));
mv.visitVarInsn(ISTORE,64);

mv.visitLdcInsn(new Long(0));
mv.visitVarInsn(LSTORE,65);

mv.visitLdcInsn(new Integer(15));
mv.visitVarInsn(ISTORE,66);

mv.visitLdcInsn(new String("stringTest"));
mv.visitVarInsn(ASTORE,67);

mv.visitTypeInsn(NEW, "asm/MyCode");
mv.visitInsn(DUP);
mv.visitIntInsn(ILOAD, 64);mv.visitIntInsn(ILOAD, 66);mv.visitMethodInsn(INVOKESPECIAL, "asm/MyCode", "<init>", "(II)V", false);
mv.visitVarInsn(ASTORE,68);

mv.visitLdcInsn(new Integer(1));
mv.visitVarInsn(ISTORE,69);

mv.visitLdcInsn(new Float(2.0));
mv.visitVarInsn(FSTORE,70);

mv.visitVarInsn(ALOAD, 68);
mv.visitIntInsn(ILOAD, 69);mv.visitMethodInsn(INVOKEVIRTUAL, "asm/MyCode", "method1", "(I)V", false);

mv.visitInsn(RETURN);     
Label lMethod1 = new Label();
mv.visitLabel(lMethod1);
mv.visitLocalVariable("this", "Lasm/main;", null, lMethod0, lMethod1, 0);
mv.visitLocalVariable("args", "[Ljava/lang/String;", null, lMethod0, lMethod1, 0);                // Return integer from top of stack
  mv.visitMaxs(0, 0);
mv.visitEnd();
}

 cw.visitEnd();
return cw.toByteArray();}
    public static void main(String [] args){
     DataOutputStream dout = null;
        try {
            dout = new DataOutputStream(new FileOutputStream("build/classes/main/asm/MyCode.class"));

        dout.write(execute());
        dout.flush();
        dout.close();
        } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
           } }
}
