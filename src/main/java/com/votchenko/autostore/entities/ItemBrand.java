package com.votchenko.autostore.entities;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tbl_itemBrand")
public class ItemBrand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "name", nullable = false)
    private  String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "itemBrand")
    private Set<Item> itemSet = new HashSet<>();

    public ItemBrand() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Item> getItemSet() {
        return itemSet;
    }

    public void setItemSet(Set<Item> itemSet) {
        this.itemSet = itemSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemBrand itemBrand = (ItemBrand) o;

        if (id != itemBrand.id) return false;
        if (name != null ? !name.equals(itemBrand.name) : itemBrand.name != null) return false;
        return itemSet != null ? itemSet.equals(itemBrand.itemSet) : itemBrand.itemSet == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (itemSet != null ? itemSet.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ItemBrand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", itemSet=" + itemSet +
                '}';
    }
}
