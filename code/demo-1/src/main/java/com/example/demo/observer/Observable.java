package com.example.demo.observer;


public interface Observable {

        public void addObserver(Observer o);
        public void removeObserver(Observer o);
        public void notifyObservers(int id, int total);
        

}
