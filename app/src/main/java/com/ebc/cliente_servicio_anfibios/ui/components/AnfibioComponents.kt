package com.ebc.cliente_servicio_anfibios.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.ebc.cliente_servicio_anfibios.R
import com.ebc.cliente_servicio_anfibios.models.Anfibio

@Composable
fun AnfibioCard(anfibio: Anfibio, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "${anfibio.name} (${anfibio.type})",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start
            )

            AsyncImage(
                modifier = Modifier.fillMaxWidth(),
                model = ImageRequest
                    .Builder(context = LocalContext.current)
                    .data(anfibio.imgSrc)
                    .crossfade(true)
                    .build(),
                contentDescription = anfibio.description,
                contentScale = ContentScale.FillWidth,
                error = painterResource(R.drawable.ic_launcher_background),
                placeholder = painterResource(R.drawable.ic_launcher_background)
            )
            Text(
                text = anfibio.description,
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(16.dp)
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AnfibioCardPreview() {
    val anfibio: Anfibio = Anfibio(
        name = "Great Basin Spadefoot",
        type = "Mi Preview",
        description = "This toad spends most of its " +
                "life underground due to the arid desert conditions " +
                "in which it lives. Spadefoot toads earn the name because " +
                "of their hind legs which are wedged to aid in digging. They " +
                "are typically grey, green, or brown with dark spots.",
        imgSrc = "https://developer.android.com/codelabs/basic-android-kotlin-compose-amphibians-app/img/great-basin-spadefoot.png"
    )

    AnfibioCard(anfibio = anfibio)
}

@Composable
fun AnfibiosListScreen(
    listaAnfibios: List<Anfibio>,
    modifier: Modifier = Modifier,
    paddingContenido: PaddingValues = PaddingValues(0.dp)
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = paddingContenido,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

    }
}

