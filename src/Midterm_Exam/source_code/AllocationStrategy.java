package Midterm_Exam.source_code;

import java.util.List;
import java.util.Map;

interface AllocationStrategy {
    void allocateComputers(List<Student> students, Map<Integer, Computer> computers);
}