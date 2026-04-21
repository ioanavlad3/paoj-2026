package com.pao.laboratory07.exercise1;

import com.pao.laboratory07.exercise1.exceptions.CannotCancelFinalOrderException;
import com.pao.laboratory07.exercise1.exceptions.CannotRevertInitialOrderStateException;
import com.pao.laboratory07.exercise1.exceptions.OrderIsAlreadyFinalException;

public enum OrderState {
    PLACED,
    PROCESSED,
    SHIPPED,
    DELIVERED,
    CANCELED;

    private static OrderState lastOrder = PLACED;

    public OrderState nextState() {
        return switch(this) {
            case PLACED -> PROCESSED;
            case PROCESSED -> SHIPPED;
            case SHIPPED -> DELIVERED;
            case DELIVERED, CANCELED -> throw new OrderIsAlreadyFinalException();
        };
    }

    public OrderState cancel() {
        return switch(this) {
            case PLACED, SHIPPED, PROCESSED -> CANCELED;
            case DELIVERED, CANCELED -> throw new CannotCancelFinalOrderException();
        };
    }


    public OrderState undoState() {
        return switch (this){
            case PLACED -> throw new CannotRevertInitialOrderStateException();
            case PROCESSED -> PLACED;
            case SHIPPED -> PROCESSED;
            case DELIVERED -> SHIPPED;
            case CANCELED -> throw new CannotCancelFinalOrderException();
        };
    }
}
