class Foo {
    private volatile int method;

    public Foo() {
        method = 0;
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        method = 1;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (method != 1) {

        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        method = 2;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (method != 2) {
            
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        method = 3;
    }
}