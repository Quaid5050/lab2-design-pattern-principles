package Midterm_Exam.source_code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class OddRegAllocationStrategy implements AllocationStrategy {
    private final List<String> allocatedDetails = new ArrayList<>();

    @Override
    public void allocateComputers(List<Student> students, Map<Integer, Computer> computers) {
        for (Student student : students) {
            if (student.getRegNo() % 2 != 0) {
                Computer linuxComputer = findLinuxComputer(computers);
                allocatedDetails.add(student.getName() + " allocated Linux computer " + linuxComputer.getComputerNo());
            }
        }
    }

    private Computer findLinuxComputer(Map<Integer, Computer> computers) {
        for (Computer computer : computers.values()) {
            if (computer.getOs().equalsIgnoreCase("Linux")) {
                return computer;
            }
        }
        throw new IllegalStateException("No Linux computers available");
    }

    public DetailsIterator createIterator() {
        return new ListDetailsIterator(allocatedDetails);
    }
}
