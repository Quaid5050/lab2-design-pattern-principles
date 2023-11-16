package Midterm_Exam.source_code;

class OddRegContainer implements Container {
    private OddRegAllocationStrategy strategy;

    public OddRegContainer(OddRegAllocationStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public DetailsIterator getIterator() {
        return strategy.createIterator();
    }
}
