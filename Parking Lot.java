// enum type for Vehicle
enum VehicleSize {
    Motorcycle,
    Compact,
    Large,
}

abstract class Vehicle {
    // Write your code here
    protected int spotsNeeded;
	protected VehicleSize size;
	protected Level level;
	protected List<ParkingSpot> parkingSpots = new ArrayList<ParkingSpot>(); 
	public int getSpotsNeeded() {
		return spotsNeeded;
	}
	public VehicleSize getSize() {
		return size;
	}
	/* Park vehicle in this spot (among others, potentially) */
	public void parkInSpot(ParkingSpot spot) {
		parkingSpots.add(spot);
	}
	/* Remove car from spot, and notify spot that it's gone */
	public void clearSpots() {
		for (ParkingSpot spot : parkingSpots) {
			spot.removeVehicle();
		}
		level.spotFree(this.spotsNeeded);
		level = null;
		parkingSpots.clear();
	}
	public void setLevel(Level level) {
	    this.level = level;
	}
	//this need to be implement in subclass
	public abstract boolean canFitInSpot(ParkingSpot spot);
}

class Motorcycle extends Vehicle {
    // Write your code here
    public Motorcycle() {
		spotsNeeded = 1;
		size = VehicleSize.Motorcycle;
	}
	
	public boolean canFitInSpot(ParkingSpot spot) {
		return true;
	}
}

class Car extends Vehicle {
    // Write your code here
    public Car() {
		spotsNeeded = 1;
		size = VehicleSize.Compact;
	}
	
	public boolean canFitInSpot(ParkingSpot spot) {
		return spot.getSize() == VehicleSize.Large || spot.getSize() == VehicleSize.Compact;
	}
}

class Bus extends Vehicle {
    // Write your code here
    public Bus() {
		spotsNeeded = 5;
		size = VehicleSize.Large;
	}

	public boolean canFitInSpot(ParkingSpot spot) {
		return spot.getSize() == VehicleSize.Large;
	}
}

class ParkingSpot {
    // Write your code here
	private Vehicle vehicle;
	private VehicleSize spotSize;

	public ParkingSpot(VehicleSize sz) {
		this.spotSize = sz;
	}
	
	/* Checks if the spot is big enough for the vehicle (and is available). This compares
	 * the SIZE only. It does not check if it has enough spots. */
	public boolean canFitVehicle(Vehicle vehicle) {
		return this.vehicle == null && vehicle.canFitInSpot(this);
	}
	
	/* Park vehicle in this spot. */
	public boolean park(Vehicle v) {
		if (!canFitVehicle(v)) {
			return false;
		}
		vehicle = v;
		vehicle.parkInSpot(this);
		return true;
	}
	/* Remove vehicle from spot, and notify level that a new spot is available */
	public void removeVehicle() {
		vehicle = null;
	}

	public VehicleSize getSize() {
		return spotSize;
	}
}

/* Represents a level in a parking garage */
class Level {
    // Write your code here
	private ParkingSpot[][] spots;
	private int availableSpots = 0;

	public Level(int num_rows, int spots_per_row) {
		spots = new ParkingSpot[num_rows][spots_per_row];
        for (int row = 0; row < num_rows; ++row) {
            for (int spot = 0; spot < spots_per_row; ++spot) {
                if (spot < spots_per_row / 4) {
                    spots[row][spot] = new ParkingSpot(VehicleSize.Motorcycle);
                } else if (spot < spots_per_row / 4 * 3) {
                    spots[row][spot] = new ParkingSpot(VehicleSize.Compact);
                } else {
                    spots[row][spot] = new ParkingSpot(VehicleSize.Large);
                }
            }
        }
        this.availableSpots = spots.length * spots[0].length;
	}

	/* Try to find a place to park this vehicle. Return false if failed. */
	public boolean parkVehicle(Vehicle vehicle) {
		if (this.availableSpots < vehicle.getSpotsNeeded()) {
			return false; // no enough spots
		}
		return parkStartingAtSpot(vehicle);
	}

	/* find a spot to park this vehicle. Return index of spot, or -1 on failure. */
	private boolean parkStartingAtSpot(Vehicle vehicle) {
		int spotsNeeded = vehicle.getSpotsNeeded();
		for (int i = 0; i < spots.length; ++i) {
		    for (int j = 0; j <= spots[0].length - spotsNeeded; ++j) {
		        if (checkAndPark(spots, i, j, spotsNeeded, vehicle)) {
		            availableSpots -= spotsNeeded;
		            vehicle.setLevel(this);
		            return true;
		        }
		    }
		}
		return false;
	}
	
	private boolean checkAndPark(ParkingSpot[][] spots, int x, int y, int size, Vehicle vehicle) {
	    for (int i = y; i < y + size; ++i) {
	        if(!spots[x][i].canFitVehicle(vehicle)) {
	            return false;
	        }
	    }
	    for (int i = y; i < y + size; ++i) {
	        spots[x][i].park(vehicle);
	    }
	    return true;
	}
	
	/* When a car was removed from the spot, increment availableSpots */
	public void spotFree(int spots) {
		availableSpots += spots;
	}
}

public class ParkingLot {
    private Level[] levels;
    // @param n number of leves
    // @param num_rows  each level has num_rows rows of spots
    // @param spots_per_row each row has spots_per_row spots
    public ParkingLot(int n, int num_rows, int spots_per_row) {
        // Write your code here
		levels = new Level[n];
		for (int i = 0; i < n; i++) {
			levels[i] = new Level(num_rows, spots_per_row);
		}
    }

    // Park the vehicle in a spot (or multiple spots)
    // Return false if failed
    public boolean parkVehicle(Vehicle vehicle) {
        // Write your code here
        for (int i = 0; i < levels.length; i++) {
			if (levels[i].parkVehicle(vehicle)) {
				return true;
			}
		}
		return false;
    }

    // unPark the vehicle
    public void unParkVehicle(Vehicle vehicle) {
        // Write your code here
        vehicle.clearSpots();
    }
}