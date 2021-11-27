package br.com.projetoviagem.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import br.com.projetoviagem.Adapter.CustomAdapterDestinos
import br.com.projetoviagem.R

class ListTrabalho : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_trabalho)

        val arrayImagens= arrayOf(
            R.drawable.sp,
            R.drawable.sc,
            R.drawable.rj,
            R.drawable.es,
            R.drawable.pr
        )
        val arrayDestinos = arrayOf("São Paulo/SP", "Florianópolis/SC", " Rio de Janeiro/RJ", "Vitória/ES", "Curitiba/PR")
        val arrayDescricao = arrayOf("Para quem quer sair da mesmice, a capital é, com certeza, uma ótima opção. Há diversos eventos culturais, shows, teatros, cinemas, museus, exposições — e o melhor, muitos deles são gratuitos. ", "Floripa, como já é chamada carinhosamente pelos brasileiros, tem conquistado cada vez mais turistas e nômades. A capital de Santa Catarina é ideal para trabalhar remotamente pois une o que há de melhor: praia, cidade grande e vida noturna agitada para os jovens.", "Os usuários do Nomad List classificaram as opções de espaço de trabalho como excelentes. E nós não podíamos concordar mais. Há coworkings para todos os gostos, desde os mais corporativos até os mais descolados.", "Vitória é conhecida por ser uma cidade para o trabalho. Aliás, na bandeira do estado vem escrito “Trabalha e Confia”. Quer coisa melhor para um nômade digital? Porém, dias de sol forte e céu azul não faltam.", "Nem só de praia vivem os nômades digitais. Curitiba é uma excelente opção de cidade grande, afastada do litoral e com um friozinho gostoso. A capital do Paraná é famosa pelo cuidado com o planejamento urbano, belas áreas verdes e um transporte público de qualidade, oferecendo um excelente padrão de vida para os moradores.")
        val destinosAdapter = CustomAdapterDestinos(this, arrayImagens, arrayDestinos, arrayDescricao)
        val listDestinos = findViewById<ListView>(R.id.idListView)
        listDestinos.adapter = destinosAdapter
    }
}