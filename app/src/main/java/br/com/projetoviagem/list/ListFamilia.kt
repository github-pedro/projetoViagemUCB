package br.com.projetoviagem.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import br.com.projetoviagem.Adapter.CustomAdapterDestinos
import br.com.projetoviagem.R

class ListFamilia : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_familia)

        val arrayImagens= arrayOf(
            R.drawable.gramado,
            R.drawable.iguacu,
            R.drawable.buzios,
            R.drawable.bahia,
            R.drawable.maceio
        )
        val arrayDestinos = arrayOf("Gramado, Rio Grande do Sul", "Foz do Iguaçu, Paraná", "Búzios, Rio de Janeiro", "Arraial d’Ajuda, Bahia", "Maceió, Alagoas")
        val arrayDescricao= arrayOf("A Serra Gaúcha costuma ser um destino que agrada qualquer idade, independente da época do ano. Com eventos nacionalmente conhecidos – do Festival Internacional de Cinema ao Natal Luz, Gramado é também uma dica perfeita para quem viaja com crianças.", "E bem no meio da fronteira do Brasil com a Argentina e Paraguai, está a simpática Foz do Iguaçu, que oferece outros belos atrativos para a família toda. Entre elas, o divertido e educativo Parque das Aves – um parque temático com 16 hectares de mata nativa, e mais de 1.500 animais para ver de perto, dentre aves, répteis e mamíferos.", "Essa é para quem curte férias na praia com a família. Búzios é um dos cartões-postais da Região dos Lagos, no Rio de Janeiro, e tem belas paisagens naturais para a família inteira.", "O clima em Arraial é para relaxar e curtir as lindas paisagens naturais sem pressa, de preferência a pé. Aliás, caminhar por entre as praias é a melhor pedida para curtir as férias com a família.", "Outra boa pedida para as famílias que gostam de praia. Afinal, são nada menos que 40 quilômetros de praias de Maceió. As águas transparentes que vão do verde clarinho ao azul turquesa, as areias douradas e os coqueirais formam cenários encantadores para os visitantes curtirem a natureza privilegiada da região.")

        val destinosAdapter = CustomAdapterDestinos(this, arrayImagens, arrayDestinos, arrayDescricao)
        val listDestinos = findViewById<ListView>(R.id.idListView)
        listDestinos.adapter = destinosAdapter

    }
}