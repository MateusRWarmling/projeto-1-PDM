package com.example.avaliacao_01;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Table {
    private boolean isReserved;
    private LinearLayout layout;
    private Button button;

    public Table(LinearLayout layout, Button btn, boolean isReserved) {
        this.layout = layout;
        this.button = btn;
        setReserved(isReserved);

        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setReserved(true);
            }
        });
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;

        button.setClickable(!isReserved);
        layout.setBackgroundColor(layout.getResources().getColor(isReserved ? R.color.reservedTable_red : R.color.freeTable_blue));
    }
}