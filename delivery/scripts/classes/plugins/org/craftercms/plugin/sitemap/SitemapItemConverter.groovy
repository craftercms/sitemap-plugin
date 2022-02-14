/*
 * MIT License
 *
 * Copyright (c) 2018-2022 Crafter Software Corporation. All Rights Reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package plugins.org.craftercms.plugin.sitemap

import org.craftercms.commons.converters.Converter
import org.craftercms.engine.model.SiteItem
import org.craftercms.engine.navigation.NavItem
import org.craftercms.engine.service.UrlTransformationService

/**
 * Implementation of {@link Converter} that wraps another instance to add
 * the properties related to sitemap as additional attributes.
 *
 * @author joseross
 */
class SitemapItemConverter implements Converter<SiteItem, NavItem> {

    /**
     * The actual converter to use
     */
    protected Converter<SiteItem, NavItem> converter

    /**
     * The service to generate URLs
     */
    protected UrlTransformationService urlTransformationService

    SitemapItemConverter(Converter<SiteItem, NavItem> converter, UrlTransformationService urlTransformationService) {
        this.converter = converter
        this.urlTransformationService = urlTransformationService
    }

    @Override
    Class<?> getSourceClass() {
        return SiteItem
    }

    @Override
    Class<?> getTargetClass() {
        return NavItem
    }

    @Override
    NavItem convert(SiteItem siteItem) {
        // Generate the regular NavItem using the converter
        def item = converter.convert(siteItem)

        // If the item is present add the sitmap attributes
        if (item) {
            item.attributes.loc = urlTransformationService.transform("storeUrlToFullRenderUrl", siteItem.storeUrl)
            item.attributes.lastmod = siteItem.lastModifiedDate?.text
            item.attributes.changefreq = siteItem.changeFrequency_s as String
            item.attributes.priority = siteItem.priority_f as String
        }
        return item
    }

}
