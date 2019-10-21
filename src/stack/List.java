package stack;

public class List <T>{
    public class Element {

        private T value;
        private Element next;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Element getNext() {
            return next;
        }

        public void setNext(Element next) {
            this.next = next;
        }

        Element(T data) {
            this.value = data;
        }

    }

    Element pierwszy = null;

    public List() {
    }

    public boolean pusta() {
        if (pierwszy == null)
            return true;
        return false;
    }

    public void insert(T elem) {
        // TODO Auto-generated method stub
        Element newElem = new Element(elem);
        Element actElem = pierwszy;

        if (pierwszy == null) {
            pierwszy = newElem;
            return;
        }
        pierwszy = pierwszy.getNext();
        newElem.setNext(actElem);
        pierwszy = newElem;

    }

    public T remove() {
        Element newElem;
        newElem = pierwszy;
        pierwszy = pierwszy.getNext();
        return newElem.getValue();
    }

    public Element getElement(int index) {
        Element actElem = pierwszy;
        while (index > 0 && actElem != null) {
            index--;
            actElem = actElem.getNext();
        }
        return actElem;
    }

    public T getElement() {
        return pierwszy.getValue();
    }
}
