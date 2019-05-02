package com.example.mvr.boaviagem;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GastoListActivity extends ListActivity implements AdapterView.OnItemClickListener {

    private List<Map<String, Object>> gastos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.gasto_list);

        String[] de = {"data", "descricao", "valor", "categoria"};
        int[] para = {R.id.data, R.id.descricao, R.id.valor, R.id.categoria};

        //setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listarGastos()));
        //ListView listView = getListView();
        //listView.setOnItemClickListener(this);

        SimpleAdapter adapter = new SimpleAdapter(this, listarGastos(), R.layout.lista_gasto, de, para);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Map<String, Object> map = gastos.get(position);
        String descricao = (String) map.get("descricao");
        String mensagem = "gasto selecionada: " + descricao;
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
        /*TextView textView = (TextView) view;
        Toast.makeText(this, "Gasto selecionado: " + textView.getText(), Toast.LENGTH_SHORT).show();*/

    }

    private List<Map<String, Object>> listarGastos(){

        gastos = new ArrayList<Map<String, Object>>();ç

        Map<String, Object> item = new HashMap<String, Object>();
        item.put("data", "04/02/2012");
        item.put("descricao", "Diária Hotel");
        item.put("valor", "R$ 260,00");
        item.put("categoria", R.color.categoria_hospedagem);
        /*gastos.add(item);
        return Arrays.asList("Sanduíche R$ 19,90",
                "Táxi Aeroporto - Hotel R$ 34,00",
                "Revista R$ 12,00");*/
        return gastos;
    }
}
