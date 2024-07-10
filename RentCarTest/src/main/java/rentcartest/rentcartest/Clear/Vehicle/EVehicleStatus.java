package rentcartest.rentcartest.Clear.Vehicle;

public enum EVehicleStatus {
    Free(0),
    Reserved(1),
    Rented(2),
    Broken(3),
    Fixing(4);

    private final Integer value;

    EVehicleStatus(Integer value){
        this.value=value;
    }
    public Integer getValue(){
        return this.value;
    }

    public static EVehicleStatus IntegerOf(Integer value){
        for ( EVehicleStatus item : EVehicleStatus.values()){
            if(value.equals(item.getValue())){
                return item;
            }
        }
        throw new IllegalArgumentException("Error !, ECategory not a value:" + value);
    }
}
