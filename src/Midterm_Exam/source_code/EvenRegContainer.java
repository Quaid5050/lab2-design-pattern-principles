package Midterm_Exam.source_code;

class EvenRegContainer implements Container {
    private EvenRegAllocationStrategy strategy;

    public EvenRegContainer(EvenRegAllocationStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public DetailsIterator getIterator() {
        return strategy.createIterator();
    }
}
