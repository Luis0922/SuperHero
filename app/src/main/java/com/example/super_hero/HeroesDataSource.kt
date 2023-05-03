package com.example.super_hero

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.super_hero.model.Hero
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign

@Composable
fun CardHero(hero: Hero, modifier: Modifier = Modifier){
    var expanded by remember { mutableStateOf(false) }
    Card(
        modifier = modifier
            .padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 4.dp)
    ){
        Column{
            Row(
                modifier = modifier
                    // Deixa todos os cards do mesmo tamanho
                    .fillMaxWidth()
            ) {
                Image(
                    modifier = modifier
                        .size(64.dp)
                        .clip(RoundedCornerShape(50))
                        .background(MaterialTheme.colorScheme.background),
                    painter = painterResource(hero.imageRes),
                    contentDescription = null
                )
                Text(
                    modifier = modifier
                        .padding(start = 16.dp, bottom = 8.dp, top = 8.dp, end = 16.dp),
                    text = stringResource(hero.nameRes),
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier.weight(1f))
                Icon(
                    painter = if(expanded) painterResource(R.drawable.baseline_expand_less) else painterResource(R.drawable.baseline_expand_more),
                    modifier = Modifier
                        .clickable { expanded = !expanded }
                        .size(45.dp)
                        .padding(top= 15.dp, end= 8.dp),
                    contentDescription = null
                )
            }
            if(expanded){
                ExpandedCard(hero.descriptionRes)
            }
        }
    }
}

@Composable
fun ExpandedCard(@StringRes descripition: Int, modifier: Modifier = Modifier){
    Column(
        modifier = modifier.padding(
            start = 16.dp,
            top = 8.dp,
            bottom = 16.dp,
            end = 16.dp
        )
    ) {
        Text(
            text = stringResource(descripition),
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Justify
        )
    }
}

