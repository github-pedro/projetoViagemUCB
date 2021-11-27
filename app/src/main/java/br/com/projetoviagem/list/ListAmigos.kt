package br.com.projetoviagem.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import br.com.projetoviagem.Adapter.CustomAdapterDestinos
import br.com.projetoviagem.R

class ListAmigos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_amigos)

        val arrayImagens= arrayOf(
            R.drawable.chapada,
            R.drawable.ilhagrande,
            R.drawable.arraial,
            R.drawable.balneario,
            R.drawable.noronha
        )
        val arrayDestinos = arrayOf("Chapada dos Veadeiros, Goiás", "Ilha Grande, Rio de Janeiro", "Arraial do Cabo, Rio de Janeiro", "Balneário Camboriú, Santa Catarina", "Fernando de Noronha, Pernambuco")
        val arrayDescricao= arrayOf("Um lugar que reúne fantásticas cachoeiras, piscinas naturais de águas termais, trilhas, belos lugares para contemplar o pôr do sol, além de uma vida noturna animada, com bares, restaurantes e feirinhas. Assim é a Chapada dos Veadeiros, um destino perfeito para ser aproveitado ao lado dos amigos. ","Daqueles destinos em que é preciso levar algumas roupas de banho, protetor solar e ótimas companhias. De resto, Ilha Grande, no litoral do Rio de Janeiro, oferece tudo o que você e seus amigos precisam para viver dias incríveis, cercados de uma natureza chocante de tão bela.","Com acesso fácil, preços baixos, dias ensolarados e praias deslumbrantes, Arraial do Cabo é uma excelente pedida para uma viagem entre amigos. ","No litoral de Santa Catarina, a grande estrela quando o assunto é praia, jovens e baladas se chama Balneário Camboriú. A cidade, apesar de não muito grande, reúne uma grande ofertas de hospedagens, restaurantes e uma vida noturna bastante agitada. ","Outra viagem inesquecível entre amigos, que exige mais plano e folga no orçamento, é Fernando de Noronha. Dispensa apresentações, não é? Considerado um dos mais belos destinos de todo o mundo, Noronha encanta pela cor da água e pela vida marinha pulsante – ideal para ser vista em mergulhos ou mesmo a olho nu")
        val destinosAdapter = CustomAdapterDestinos(this, arrayImagens, arrayDestinos, arrayDescricao)
        val listDestinos = findViewById<ListView>(R.id.idListView)
        listDestinos.adapter = destinosAdapter

    }
}