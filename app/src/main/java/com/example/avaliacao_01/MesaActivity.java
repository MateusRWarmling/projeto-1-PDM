package com.example.avaliacao_01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.avaliacao_01.utils.Shared;

public class MesaActivity extends AppCompatActivity {

    Table tables[] = new Table[9];
    private EditText freeTableEditText;
    private Button unlockTableButton;
    private Button saveButton;
    private Button reserveAllTablesButton;
    private Shared shared = new Shared(MesaActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);

        freeTableEditText = findViewById(R.id.freeTableEditText);
        unlockTableButton = findViewById(R.id.unlockTableButton);
        saveButton = findViewById(R.id.saveButton);
        reserveAllTablesButton = findViewById(R.id.reserveAllTablesButton);

        tables[0] = new Table(findViewById(R.id.table1), findViewById(R.id.buttonReserva1), shared.getBoolean("table0"));
        tables[1] = new Table(findViewById(R.id.table2), findViewById(R.id.buttonReserva2), shared.getBoolean("table1"));
        tables[2] = new Table(findViewById(R.id.table3), findViewById(R.id.buttonReserva3), shared.getBoolean("table2"));
        tables[3] = new Table(findViewById(R.id.table4), findViewById(R.id.buttonReserva4), shared.getBoolean("table3"));
        tables[4] = new Table(findViewById(R.id.table5), findViewById(R.id.buttonReserva5), shared.getBoolean("table4"));
        tables[5] = new Table(findViewById(R.id.table6), findViewById(R.id.buttonReserva6), shared.getBoolean("table5"));
        tables[6] = new Table(findViewById(R.id.table7), findViewById(R.id.buttonReserva7), shared.getBoolean("table6"));
        tables[7] = new Table(findViewById(R.id.table8), findViewById(R.id.buttonReserva8), shared.getBoolean("table7"));
        tables[8] = new Table(findViewById(R.id.table9), findViewById(R.id.buttonReserva9), shared.getBoolean("table8"));

        unlockTableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final int tableNumber = Integer.parseInt(freeTableEditText.getText().toString());

                    if (!tables[tableNumber - 1].isReserved()) {
                        Toast.makeText(MesaActivity.this, getString(R.string.tableFree).replace("{tableNum}", String.valueOf(tableNumber)), Toast.LENGTH_LONG).show();
                        return;
                    }

                    tables[tableNumber - 1].setReserved(false);
                } catch (Exception e) {
                    Toast.makeText(MesaActivity.this, getString(R.string.tableDontExist), Toast.LENGTH_LONG).show();
                }
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < tables.length; i++) {
                    shared.put("table" + String.valueOf(i), tables[i].isReserved());
                }
            }
        });

        reserveAllTablesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean wasFree = false;

                for (int i = 0; i < tables.length; i++) {
                    if (!wasFree) {
                        wasFree = !tables[i].isReserved();
                    }

                    tables[i].setReserved(true);
                }

                if (!wasFree) {
                    Toast.makeText(MesaActivity.this, getString(R.string.tableOccupied), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
