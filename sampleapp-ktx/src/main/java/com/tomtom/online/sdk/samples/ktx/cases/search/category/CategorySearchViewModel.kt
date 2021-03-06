/*
 * Copyright (c) 2015-2020 TomTom N.V. All rights reserved.
 *
 * This software is the proprietary copyright of TomTom N.V. and its subsidiaries and may be used
 * for internal evaluation purposes or commercial use strictly subject to separate licensee
 * agreement between you and TomTom. If you are the licensee, you are only permitted to use
 * this Software in accordance with the terms of your license agreement. If you are not the
 * licensee then you are not authorised to use this software in any manner and should
 * immediately return it to TomTom N.V.
 */

package com.tomtom.online.sdk.samples.ktx.cases.search.category

import android.app.Application
import com.tomtom.online.sdk.samples.ktx.cases.search.SearchViewModel
import com.tomtom.online.sdk.search.fuzzy.FuzzySearchSpecification
import com.tomtom.online.sdk.search.fuzzy.FuzzyLocationDescriptor
import com.tomtom.online.sdk.search.fuzzy.FuzzySearchEngineDescriptor

class CategorySearchViewModel(application: Application) : SearchViewModel(application) {

    override fun search(term: String) {
        addPreciseness()?.let { preciseness ->
            //tag::doc_create_category_specification_plain_text[]
            val locationDescriptor = FuzzyLocationDescriptor.Builder()
                .positionBias(preciseness)
                .build()

            val searchEngineDescriptor = FuzzySearchEngineDescriptor.Builder()
                .category(true)
                .build()

            val categorySearchSpecification = FuzzySearchSpecification.Builder(term)
                .searchEngineDescriptor(searchEngineDescriptor)
                .locationDescriptor(locationDescriptor)
                .build()
            //end::doc_create_category_specification_plain_text[]
            search(categorySearchSpecification)
        }
    }
}