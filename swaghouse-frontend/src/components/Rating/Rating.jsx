import React, { useMemo } from 'react';
import SvgStarIcon from '../common/SvgStarIcon';
import { SvgEmptyStar } from '../common/SvgEmptyStar';

const Rating = ({ rating }) => {
  const { filledStars, emptyStars } = useMemo(() => {
    const safeRating = Math.max(0, Math.min(5, Math.floor(Number(rating)) || 0));
    return {
      filledStars: Array(safeRating).fill(null),
      emptyStars: Array(5 - safeRating).fill(null),
    };
  }, [rating]);

  return (
    <div className="flex items-center">
      {filledStars.map((_, index) => (
        <SvgStarIcon key={`filled-${index}`} />
      ))}
      {emptyStars.map((_, index) => (
        <SvgEmptyStar key={`empty-${index}`} />
      ))}
      <p className="px-2 text-gray-500">{Number(rating)?.toFixed(1) || '0.0'}</p>
    </div>
  );
};

export default Rating;
