import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

class Instruction {
    String operation;
    Integer argument;

    public Instruction(String operation, Integer argument) {
        this.operation = operation;
        this.argument = argument;
    }
}

public class Day8 {
    public static boolean executeProgram(List<Instruction> instructionList) {

        Integer acc = 0;
        int instructionPointer = 0;

        boolean[] executed = new boolean[instructionList.size()];
        for (int i = 0; i < executed.length; i++) {
            executed[i] = false;
        }
        while (true) {
            executed[instructionPointer] = true;
            Instruction ist = instructionList.get(instructionPointer);
            if (ist.operation.equals("acc")) {
                acc += ist.argument;
                instructionPointer++;
            } else if (ist.operation.equals("jmp")) {
                instructionPointer += ist.argument;
            } else {
                instructionPointer++;
            }
            if (instructionPointer == executed.length) {
                break;
            }
            if (executed[instructionPointer]) {
                return false;
            }
        }
        System.out.println(acc);
        return true;
    }

    public static void main(String[] args) {
        File file = new File("/home/hjh/Algorithm/AdventOfCode2020/Java/src/p8Input.txt");
        try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr);) {
            String line = null;
            List<Instruction> instructionList = new ArrayList<>();

            int idx = 0;
            while ((line = br.readLine()) != null) {
                String[] spt = line.split(" ");
                String operation = spt[0];
                Integer argument = Integer.parseInt(spt[1]);
                instructionList.add(new Instruction(operation, argument));
                idx++;
            }

            for (int i = 0; i < instructionList.size(); i++) {
                Instruction ist = instructionList.get(i);
                if (ist.operation.equals("jmp")) {
                    ist.operation = "nop";
                    if (executeProgram(instructionList)) {
                        System.out.println("answer ↑");
                    }
                    ist.operation = "jmp";
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
