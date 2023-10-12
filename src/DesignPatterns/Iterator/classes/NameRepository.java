package DesignPatterns.Iterator.classes;

import DesignPatterns.Iterator.interfaces.Container;
import DesignPatterns.Iterator.interfaces.Iterator;

public class NameRepository implements Container {
    public Iterator getIterator() {
        return new NameIterator();
    }


    private class NameIterator implements Iterator {
         int index;
        public NameIterator() {
            index = 0;

        }

        public Student names[]={
                new Student(1, "Quaid Ahmed", "Male", "123-456-7890"),
                new Student(2, "Qaziiii", "Male", "123-456-7890"),
                new Student(2, "Shah je", "Male", "123-456-7890"),
                new Student(3, "GZain", "Male", "123-456-7890"),

        };


         @Override
         public boolean hasNext() {
             if (index < names.length) {
                 return true;
             }
             return false;
         }

         @Override
         public Object next() {
             if (this.hasNext()) {
                 return names[index++];
             }
             return null;
         }
         @Override
         public Object previous() {
                if (this.hasPrevious()) {
                    return names[index--];
                }
                return null;
            }

        @Override
        public boolean hasPrevious() {
            if (index > 0) {
                return true;
            }
            return false;
        }

        @Override
        public void moveToLast() {
             index = names.length - 1;
        }

        @Override
        public void moveToFirst() {
            index = 0;
        }

    }
}
