package com.votchenko.autostore.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tbl_itemtype")
public class ItemType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "name")
    private  String name;

    @OneToMany(fetch =FetchType.LAZY, mappedBy = "itemType")
    private Set<Item> itemSet = new HashSet<>();

    public ItemType() {
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

        ItemType itemType = (ItemType) o;

        if (id != itemType.id) return false;
        if (name != null ? !name.equals(itemType.name) : itemType.name != null) return false;
        return itemSet != null ? itemSet.equals(itemType.itemSet) : itemType.itemSet == null;
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
        return "ItemType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", itemSet=" + itemSet +
                '}';
    }
}
