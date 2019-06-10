package guru.springframework.models;

import javax.persistence.*;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by jleoirab on 2019-06-09
 */
@Entity
public class MeasuredIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Ingredient ingredient;

    private float amount;

    public MeasuredIngredient() {

    }

    public MeasuredIngredient(Ingredient ingredient, float amount) {
        this.ingredient = checkNotNull(ingredient);
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
