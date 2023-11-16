package Midterm_Exam.source_code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class EvenRegAllocationStrategy implements AllocationStrategy {
    private List<String> allocatedDetails = new ArrayList<>();

    @Override
    public void allocateComputers(List<Student> students, Map<Integer, Computer> computers) {
        for (Student student : students) {
            if (student.getRegNo() % 2 == 0) {
                Computer windowsComputer = findWindowsComputer(computers);
                allocatedDetails.add(student.getName() + " allocated Windows computer " + windowsComputer.getComputerNo());
            }
        }
    }

    private Computer findWindowsComputer(Map<Integer, Computer> computers) {
        for (Computer computer : computers.values()) {
            if (computer.getOs().equalsIgnoreCase("Windows")) {
                return computer;
            }
        }
        throw new IllegalStateException("No Windows computers available");
    }

    public DetailsIterator createIterator() {
        return new ListDetailsIterator(allocatedDetails);
    }
}
