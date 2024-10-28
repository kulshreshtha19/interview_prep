package Patterns.Behavioural.VisitorPattern;


interface RoomVisitor {
    void visit(SingleRoom singleRoom);
    void visit(DoubleRoom doubleRoom);
    void visit(TripleRoom tripleRoom);
}

class RoomPricingVisitor implements RoomVisitor{

    @Override
    public void visit(SingleRoom singleRoom) {
        System.out.println(singleRoom.roomPrice);
    }

    @Override
    public void visit(DoubleRoom doubleRoom) {
        System.out.println(doubleRoom.roomPrice);
    }

    @Override
    public void visit(TripleRoom tripleRoom) {
        System.out.println(tripleRoom.roomPrice);
    }
}


interface Room {
    void accept(RoomVisitor roomVisitor);
}

class SingleRoom implements Room {

    public Integer roomPrice = 100;

    @Override
    public void accept(RoomVisitor roomVisitor) {
        roomVisitor.visit(this);
    }
}

class DoubleRoom implements Room {
    public Integer roomPrice = 100;

    @Override
    public void accept(RoomVisitor roomVisitor) {
        roomVisitor.visit(this);
    }
}

class TripleRoom implements Room {

    public Integer roomPrice = 10;

    @Override
    public void accept(RoomVisitor roomVisitor) {
        roomVisitor.visit(this);
    }
}


public class Main {

    public static void main(String args[]) {
        RoomVisitor roomVisitor = new RoomPricingVisitor();
        Room singleRoom = new SingleRoom();
        singleRoom.accept(roomVisitor);
    }
}
