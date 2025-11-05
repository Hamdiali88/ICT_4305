package parking;

import java.util.*;

public class PermitManager {
    private final Map<String, ParkingPermit> permitsById = new HashMap<>();
    private final Map<String, List<String>> permitIdsByCustomer = new HashMap<>();
    private long sequence = 1L;

    public ParkingPermit register(Car car) {
        if (car == null) throw new IllegalArgumentException("car must not be null");
        String id = String.format("PERM-%05d", sequence++);
        return registerWithId(car, id, car.getOwnerCustomerId());
    }

    // --- Added for legacy compatibility (explicit ID + customer binding) ---
    public ParkingPermit registerWithId(Car car, String permitId, String customerId) {
        if (car == null) throw new IllegalArgumentException("car must not be null");
        if (permitId == null || permitId.isBlank()) throw new IllegalArgumentException("permitId required");
        if (customerId == null || customerId.isBlank()) throw new IllegalArgumentException("customerId required");

        Calendar now = Calendar.getInstance();
        Calendar exp = (Calendar) now.clone();
        exp.add(Calendar.YEAR, 1);

        ParkingPermit permit = new ParkingPermit(permitId, car, exp, now);
        permitsById.put(permitId, permit);
        permitIdsByCustomer.computeIfAbsent(customerId, k -> new ArrayList<>()).add(permitId);
        return permit;
    }

    public Collection<String> getAllPermitIds() {
        return Collections.unmodifiableSet(permitsById.keySet());
    }

    public Collection<String> getPermitIdsByCustomer(String customerId) {
        if (customerId == null) return Collections.emptyList();
        List<String> ids = permitIdsByCustomer.get(customerId);
        return ids == null ? Collections.emptyList() : Collections.unmodifiableList(ids);
    }

    public ParkingPermit findById(String permitId) {
        return permitsById.get(permitId);
    }
}
