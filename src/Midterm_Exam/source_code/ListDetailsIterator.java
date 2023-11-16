package Midterm_Exam.source_code;

import java.util.List;
import java.util.NoSuchElementException;

class ListDetailsIterator implements DetailsIterator {
    private List<String> details;
    private int position = 0;

    public ListDetailsIterator(List<String> details) {
        this.details = details;
    }

    @Override
    public boolean hasNext() {
        return position < details.size();
    }

    @Override
    public String next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return details.get(position++);
    }
}
