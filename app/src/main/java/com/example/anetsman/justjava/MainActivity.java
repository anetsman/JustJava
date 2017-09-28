package com.example.anetsman.justjava;

/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
 *
 */

import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    private static int currentQuantity = 0;
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
        displayPrice(currentQuantity*5);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        quantityTextView.setText("" + number);
    }

    private void displayPrice(int price) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        String priceOutput = String.format("Total: $%s \nThank you!", (double) price);
        priceTextView.setText(priceOutput);
    }

    public void increment(View view) {
        display(currentQuantity + 1);
        currentQuantity += 1;
    }

    public void decrement(View view) {
        display(currentQuantity - 1);
        currentQuantity -= 1;
    }
}