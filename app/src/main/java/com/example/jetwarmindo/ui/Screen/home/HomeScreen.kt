package com.example.jetwarmindo.ui.Screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetwarmindo.R
import com.example.jetwarmindo.di.Injection
import com.example.jetwarmindo.model.FakeFoodDataSource.dummyFoods
import com.example.jetwarmindo.model.Food
import com.example.jetwarmindo.ui.ViewModelFactory
import com.example.jetwarmindo.ui.common.UiState
import com.example.jetwarmindo.ui.components.FoodItem
import com.example.jetwarmindo.ui.components.HomeSection

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository())
    ),
    navigateToDetail: (Long) -> Unit,
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getAllFoods()
            }
            is UiState.Success -> {
                HomeContent(
                    modifier = modifier,
                    navigateToDetail = navigateToDetail,
                )
            }
            is UiState.Error -> {}
        }
    }
}

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    navigateToDetail: (Long) -> Unit,
) {
        Column(
            modifier = modifier
                .verticalScroll(rememberScrollState())
        ) {
            Banner()
            HomeSection(
                title = stringResource(R.string.section_foods),
                content = { MenuRow(
                    dummyFoods,
                    modifier = modifier,
                    navigateToDetail,
                ) }
            )
            HomeSection(
                title = stringResource(R.string.section_foods),
                content = { MenuRow(
                    dummyFoods,
                    modifier = modifier,
                    navigateToDetail,
                ) }
            )
        }
    }

@Composable
fun Banner(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(R.drawable.image_warmindo),
            contentDescription = "Banner Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(160.dp)
        )
    }
}

@Composable
fun MenuRow(
    listMenu: List<Food>,
    modifier: Modifier = Modifier,
    navigateToDetail: (Long) -> Unit,
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(listMenu, key = { it.title }) { menu ->
            FoodItem(
                menu = menu,
                modifier = Modifier.clickable {
                    navigateToDetail(menu.id)
                }
                )
        }
    }
}