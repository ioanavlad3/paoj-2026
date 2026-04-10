package com.pao.laboratory07.exercise1;

import com.pao.laboratory07.exercise1.exceptions.CannotCancelFinalOrderException;
import com.pao.laboratory07.exercise1.exceptions.CannotRevertInitialOrderStateException;
import com.pao.laboratory07.exercise1.exceptions.OrderIsAlreadyFinalException;

import java.util.Stack;

public class Order {
    private OrderState currentState;
    private Stack<OrderState> history = new Stack<>();

    public Order(OrderState initialState) {
        this.currentState = initialState;
    }

    public void nextState() {
        this.history.push(currentState);
        this.currentState = this.currentState.nextState();
        System.out.println("Order state updated to: " + this.currentState);
    }

    public void cancel() {
        history.push(currentState);

        currentState = currentState.cancel();
        System.out.println("Order has been canceled.");

    }

    public void undoState() {
        if (history.isEmpty()) {
            throw new CannotRevertInitialOrderStateException();
        }
        currentState = history.pop();
        System.out.println("Order state reverted to: " + currentState);
    }

    public OrderState getCurrentState() {
        return currentState;
    }
}