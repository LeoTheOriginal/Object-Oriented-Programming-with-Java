set terminal pngcairo size 800,800
set output 'results.png'
set size square
set xrange [0:100]
set yrange [0:100]
set style line 1 lc rgb 'red' pt 7 ps 1.5

# Plot results
plot 'results.dat' using 1:2 with points pt 7 lc rgb "blue" title 'Voronoi Edges', \
     'points.dat' using 1:2 with points pt 7 lc rgb "red" title 'Input Points'