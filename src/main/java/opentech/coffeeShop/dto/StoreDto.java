package opentech.coffeeShop.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import opentech.coffeeShop.Entity.Store;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class StoreDto {
    private Long id;
    private String name;
    private String address;

    public Store toStore() {
        Store store = new Store();
        store.setId(id);
        store.setName(name);
        store.setAddress(address);
        return store;
    }

    public static StoreDto fromStore(Store store) {
        StoreDto storeDto = new StoreDto();
        storeDto.setId(store.getId());
        storeDto.setName(store.getName());
        storeDto.setAddress(store.getAddress());
        return storeDto;
    }
}
