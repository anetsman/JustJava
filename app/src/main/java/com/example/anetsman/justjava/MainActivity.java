package com.example.anetsman.justjava;

/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 * <p>
 * package com.example.android.justjava;
 */

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    private static int currentQuantity = 1;
    private static boolean withWhippedCream = false;
    private static boolean withChocolate = false;
    private static final int pricePerCoffee = 5;
    private static final int priceForCream = 1;
    private static final int priceForChocolate = 2;
    private final CharSequence lessThenOneCup = "You cannot order less thten 1 cup";
    private TextView quantityTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        display(currentQuantity);
        int price = calculatePrice(currentQuantity);
        createOrderSummary(price);
    }

    /**
     * This method calculates total price.
     */
    private int calculatePrice(int currentQuantity) {
        return (pricePerCoffee + (withWhippedCream ? priceForCream : 0) +
                (withChocolate ? priceForChocolate : 0)) * currentQuantity;
    }

    /**
     * This method creates order and print it to the screen.
     */
    public void createOrderSummary(int price) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        String priceOutput = String.format(
                "Name: %s\nQuantity: %s\nAdd whipped cream? %s\nAdd chocolate? %s\nTotal: $%s \nThank you!",
                getName(), currentQuantity, String.valueOf(withWhippedCream), String.valueOf(withChocolate), price);
        orderSummaryTextView.setText(priceOutput);
    }

    /**
     * This method reads the name of user.
     * @return name
     */
    private String getName() {
        EditText name = (EditText) findViewById(R.id.name);
        return String.valueOf(name.getText());
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        quantityTextView.setText("" + number);
    }

    /**
     * This method adds whipped cream.
     * called on checking Whipped Cream checkbox
     */
    public void addWhippedCream(View view) {
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream);
        withWhippedCream = whippedCreamCheckBox.isChecked();
    }

    /**
     * This method adds chocolate.
     * called on checking Chocolate checkbox
     */
    public void addChocolate(View view) {
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate);
        withChocolate = chocolateCheckBox.isChecked();
    }

    /**
     * This method adds one cup of coffee.
     * called on "+" clicking
     */
    public void increment(View view) {
        if (currentQuantity < 100) {
            display(currentQuantity + 1);
            currentQuantity += 1;
        }
    }

    /**
     * This method removes one cup of coffee.
     * called on "-" clicking
     */
    public void decrement(View view) {
        if (currentQuantity > 1) {
            display(currentQuantity - 1);
            currentQuantity -= 1;
        } else{
            Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, lessThenOneCup, duration);
            toast.show();
        }

    }
}