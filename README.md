# SASA
[Squints At Sorting Algorithms] - Preformance tests &amp; Implementation of Heapsort, Quicksort and Mergesort

<p>
    Some observations based on data generated from my Reporting1 class, printed to the console and then manually entered into excel to generate these graphs
    (fun and pretty graphs and datatable provided in "krc53_WrittenReport.pdf", analyzed results provided in and in “Reporting1results.txt”):
</p>
<ul>
    <li>
        <strong>Heapsort </strong>
        uses the most efficient number of comparisons, but requires data to be shifted around significantly, unless the data is already decreasing (then the
        siftdown method doesn’t have to do much work). For this reason, it outperforms all other sorts on decreasing arrays of significant size. However, it
        preforms poorly on large random arrays and small sorted arrays.
    </li>
    <li>
        <strong>Quicksort</strong>
        tends to have the overall lowest runtime because it requires a low number of comparisons as well. This algorithm is generally efficient for the array
        datastructure, with the exception of decreasing arrays, which Heapsort outperforms all in.
    </li>
    <li>
        <strong>Mergesort</strong>
        is generally slow, only outperforming Heapsort when preformed on an increasing array and significantly large random arrays. This is understandable,
        because the data structure used for testing was an array. Mergesort works best on data structures that are not operated on in place, but instead
        moveable, such as linked list. For this reason, Mergesort would be a good option on very large amounts of data that require large amounts of memory.
    </li>
</ul>
